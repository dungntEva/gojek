package com.example.myapplication.data.network

import com.google.gson.annotations.SerializedName

data class LocationApiDto (
    @SerializedName("street")
    val street: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("zip")
    val zip: String
)