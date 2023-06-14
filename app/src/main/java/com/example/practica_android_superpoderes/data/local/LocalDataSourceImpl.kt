package com.example.practica_android_superpoderes.data.local

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: SuperheroDAO): LocalDataSource {

    override suspend fun getHeros(): List<LocalHero>{
        return dao.getAll()
    }

    override suspend fun insertHero(localSuperhero: LocalHero) {
        TODO("Not yet implemented")
    }

    override suspend fun getHero(id: String): List<LocalHero>{
        return dao.getHero(id)
    }

    override suspend fun updateHero(hero: LocalHero){
        dao.updateHero(hero)
    }

    override suspend fun insertHeros(localSuperheros: List<LocalHero>){
        dao.insertAllList(localSuperheros)
    }

}
