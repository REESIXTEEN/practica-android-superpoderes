package com.example.practica_android_superpoderes.data.remote.response

import com.squareup.moshi.Json

class DataBaseResponse(
        @Json(name = "results") val characters: List<CharacterResponse>,
        @Json(name = "offset") val offset: Int,
        @Json(name = "total") val total: Int
)