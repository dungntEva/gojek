package com.example.myapplication.data.network

import com.google.gson.annotations.SerializedName

data class NameApiDto (
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)