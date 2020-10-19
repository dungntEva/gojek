package com.example.myapplication.data.network

import com.example.myapplication.data.domain.Randoms
import io.reactivex.Observable
import retrofit2.http.GET

interface RandomApiService {

    @GET("?randomapi")
    fun getRandoms(): Observable<Randoms>
}