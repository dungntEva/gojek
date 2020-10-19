package com.example.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.domain.Random
import com.example.myapplication.data.repositories.RandomRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RandomApiViewModel(
    private val randomRepository: RandomRepository
) : ViewModel() {
    private var disposable: Disposable? = null

    val randomApi by lazy {
        MutableLiveData<Result<List<Random>>>()
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun loadRandomApi() {
        disposable = randomRepository.getRandomApi()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { value -> randomApi.value = Result.success(value) },
                { value -> randomApi.value = Result.failure(value) },
                { println("Getting answer completed") }
            )
    }
}