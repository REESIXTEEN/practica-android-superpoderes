package com.example.practica_android_superpoderes.data.remote.response

import com.squareup.moshi.Json

class CharacterResponse (
        @Json(name = "id") val id: Int,
        @Json(name = "name") val name: String,
        @Json(name = "description") val description: String,
        @Json(name = "thumbnail") val thumbnail: ThumbnailResponse,
        @Json(name = "comics") val comics: ComicsResponse,
)

