package com.example.myapplication.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.myapplication.R
import com.example.myapplication.viewmodels.RandomApiViewModel
import com.example.myapplication.viewmodels.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_fragment.*
import kotlin.random.Random

class RandomApiFragment  : Fragment() {

    companion object {
        fun newInstance() =
            RandomApiFragment()
    }

    private val randomApiViewModel by lazy {
        ViewModelProvider(viewModelStore,
            ViewModelFactory()
        ).get(RandomApiViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLiveData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingAnswer.visibility = View.VISIBLE
        randomApiViewModel.loadRandomApi()
    }

    private fun observeLiveData() {
        activity?.let { main ->
            randomApiViewModel.randomApi.observe(main, Observer { result ->
                result.onSuccess {
                    for (item in it) {
                        title.text = item.user.name.first
                            .plus(" ")
                            .plus(item.user.name.last)
                            .plus(" ")
                            .plus(item.user.name.title)
                            .plus("\n")
                            .plus(item.user.email)
                            .plus("\n")
                            .plus(item.user.location.street)
                            .plus(", ")
                            .plus(item.user.location.state)
                            .plus(", ")
                            .plus(item.user.location.city)
                        loadGifFromURL(item.user.picture,
                            requireContext(),
                            answerGif)
                    }
                }
                result.onFailure {
                    resolveAnswerLocally()
                }
            })
        }
    }

    private fun resolveAnswerLocally(){
        when(Random.nextInt(0, 2)){
            0 -> loadGifFromLocal(R.drawable.yes_default, requireContext(), answerGif)
            1 -> loadGifFromLocal(R.drawable.no_default, requireContext(), answerGif)
        }
    }

    private fun showMessage(resId: Int){
        val snackbar = Snackbar.make(
            main,
            resId,
            Snackbar.LENGTH_LONG
        )
        snackbar.view.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorSnackbarError))
        snackbar.show()
    }

    /**
     * Glide methods
     */

    private fun loadGifFromURL(url: String, context: Context, imageview: ImageView){
        Glide
            .with(context)
            .load(url)
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    //If resource from URL fail then resolve using local resource
                    resolveAnswerLocally()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    loadingAnswer.visibility = View.GONE
                    return false
                }
            })
            .into(imageview)
    }

    /**
     * Analogue to previous method's comment
     */
    private fun loadGifFromLocal(rawResId: Int, context: Context, imageview: ImageView){
        Glide
            .with(context)
            .load(rawResId)
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    showMessage(R.string.error_msg_no_network_no_local_gif)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    showMessage(R.string.warn_msg_no_network_show_local_gif)
                    return false
                }

            })
            .into(imageview)
    }
}