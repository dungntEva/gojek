package com.example.myapplication.data.repositories

import com.example.myapplication.data.domain.Random
import com.example.myapplication.data.domain.Randoms
import io.reactivex.Observable

interface RandomRepository {

    fun getRandomApi(): Observable<List<Random>>?
}