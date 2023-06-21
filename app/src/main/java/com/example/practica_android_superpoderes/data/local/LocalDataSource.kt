package com.example.practica_android_superpoderes.data.local

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getHeros(): Flow<List<LocalHero>>

    suspend fun getCount(): Int

    suspend fun insertHero(localSuperhero: LocalHero)

    suspend fun insertHeros(localSuperheros: List<LocalHero>)

    suspend fun getHero(id: String): Flow<LocalHero>

    suspend fun updateHero(hero: LocalHero)
}
