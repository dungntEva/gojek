package com.example.myapplication.data.repositories

import com.example.myapplication.data.network.RetrofitClient
import com.example.myapplication.data.network.RandomApiService

object FactoryRandomApiRepository {
    private var randomRepoImpl: RandomRepository? = null

    fun getRandomRepo():RandomRepository {
        if(randomRepoImpl == null){
            randomRepoImpl = RandomRepositoryImpl(
                randomApiService = RetrofitClient.getService(RandomApiService::class.java)
            )
        }
        return randomRepoImpl as RandomRepository
    }
}