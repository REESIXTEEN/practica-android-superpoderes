package com.example.practica_android_superpoderes.data

import com.example.practica_android_superpoderes.ui.model.Hero

interface Repository {
    suspend fun getHeros(): List<Hero>
}
