package com.example.practica_android_superpoderes.data.remote.response

import com.squareup.moshi.Json

class MarvelBaseResponse<T>(
        @Json(name = "code") var code: Int,
        @Json(name = "status") var status: String,
        @Json(name = "data") var data: T?
)