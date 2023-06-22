package com.example.practica_android_superpoderes.data.remote.response

import com.squareup.moshi.Json

class CharacterComicsResponse (
        @Json(name = "id") val id: Int,
        @Json(name = "title") val title: String,
        @Json(name = "thumbnail") val thumbnail: ThumbnailResponse
)

