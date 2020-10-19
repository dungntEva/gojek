package com.example.myapplication.data.repositories

import com.example.myapplication.data.domain.*
import com.example.myapplication.data.network.*

fun RandomsApiDto.toDomain() = Randoms(
    results = results
)

//fun RandomApiDto.toRandom() = Random(
//    user = user,
//    seed = seed,
//    version = version
//)
//
//fun UserApiDto.toUser() = User(
//    gender = gender,
//    name = name,
//    location = location,
//    email = email,
//    username = username,
//    password = password,
//    salt = salt,
//    md5 = md5,
//    sha1 = sha1,
//    sha256 = sha256,
//    registered = registered,
//    dob = dob,
//    phone = phone,
//    cell = cell,
//    SSN = SSN,
//    picture = picture
//)
//
//fun LocationApiDto.toLocation() = Location(
//    street = street,
//    city = city,
//    state = state,
//    zip = zip
//)
//
//fun NameApiDto.toName() = Name(
//    title = title,
//    first = first,
//    last = last
//)