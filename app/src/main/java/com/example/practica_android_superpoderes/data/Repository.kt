package com.example.practica_android_superpoderes.data

import com.example.practica_android_superpoderes.ui.model.Hero
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getHeros(): Flow<List<Hero>>

    suspend fun getHero(id: String): Flow<Hero>

    suspend fun updateHero(hero: Hero)

}
