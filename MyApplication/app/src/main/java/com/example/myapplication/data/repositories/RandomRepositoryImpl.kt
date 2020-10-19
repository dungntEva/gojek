package com.example.myapplication.data.repositories

import com.example.myapplication.data.domain.Random
import io.reactivex.Observable
import com.example.myapplication.data.network.RandomApiService

class RandomRepositoryImpl(
    private val randomApiService: RandomApiService
): RandomRepository {
    override fun getRandomApi(): Observable<List<Random>>? {
        return randomApiService.getRandoms().map {it.results}
    }
}