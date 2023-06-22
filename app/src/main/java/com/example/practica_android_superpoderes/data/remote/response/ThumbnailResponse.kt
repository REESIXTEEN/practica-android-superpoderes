package com.example.practica_android_superpoderes.data.remote.response

import com.squareup.moshi.Json

class ThumbnailResponse(
        @Json(name = "path") var path: String,
        @Json(name = "extension") var extension: String
)