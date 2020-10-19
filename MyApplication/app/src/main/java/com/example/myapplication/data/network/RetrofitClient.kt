package com.example.myapplication.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {


    private val retrofit by lazy {

        val okHttpClient = OkHttpClient.Builder()
            .build()

        Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/0.4/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    fun <T> getService(klass: Class<T>): T {
        return retrofit.create(klass)
    }
}