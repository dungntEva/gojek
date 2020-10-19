package com.example.myapplication.data.network

import com.example.myapplication.data.domain.User
import com.google.gson.annotations.SerializedName

data class RandomApiDto(
    @SerializedName("user")
    val user: User,
    @SerializedName("seed")
    val seed: String,
    @SerializedName("version")
    val version: String
)