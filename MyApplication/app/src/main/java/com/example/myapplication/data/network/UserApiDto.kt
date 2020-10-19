package com.example.myapplication.data.network

import com.example.myapplication.data.domain.Location
import com.example.myapplication.data.domain.Name
import com.google.gson.annotations.SerializedName

data class UserApiDto (
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: Name,
    @SerializedName("location")
    val location: Location,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("salt")
    val salt: String,
    @SerializedName("md5")
    val md5: String,
    @SerializedName("sha1")
    val sha1: String,
    @SerializedName("sha256")
    val sha256: String,
    @SerializedName("registered")
    val registered: String,
    @SerializedName("dob")
    val dob: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("cell")
    val cell: String,
    @SerializedName("SSN")
    val SSN: String,
    @SerializedName("picture")
    val picture: String
)