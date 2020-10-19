package com.example.myapplication.data.network

import com.example.myapplication.data.domain.Random
import com.google.gson.annotations.SerializedName

data class RandomsApiDto (
    @SerializedName("results")
    val results: List<Random>
)