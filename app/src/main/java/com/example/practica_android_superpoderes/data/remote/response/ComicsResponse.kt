package com.example.practica_android_superpoderes.data.remote.response

import com.squareup.moshi.Json

data class ComicsResponse(
        @Json(name = "available") val available: Int
)