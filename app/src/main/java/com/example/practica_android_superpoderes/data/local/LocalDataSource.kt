package com.example.practica_android_superpoderes.data.local

import com.example.practica_android_superpoderes.data.local.model.LocalHero

interface LocalDataSource {
    suspend fun getHeros(): List<LocalHero>

    suspend fun insertHero(localSuperhero: LocalHero)

    suspend fun insertHeros(localSuperheros: List<LocalHero>)

    suspend fun getHero(id: String): List<LocalHero>

    suspend fun updateHero(hero: LocalHero)
}
