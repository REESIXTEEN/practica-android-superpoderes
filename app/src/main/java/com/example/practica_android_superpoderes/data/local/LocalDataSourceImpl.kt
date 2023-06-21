package com.example.practica_android_superpoderes.data.local

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: SuperheroDAO): LocalDataSource {

    override suspend fun getHeros(): Flow<List<LocalHero>> {
        return dao.getAll()
    }

    override suspend fun getCount(): Int {
        return dao.getCount()
    }

    override suspend fun insertHero(localSuperhero: LocalHero) {
        TODO("Not yet implemented")
    }

    override suspend fun getHero(id: String): Flow<LocalHero> {
        return dao.getHero(id)
    }

    override suspend fun updateHero(hero: LocalHero){
        dao.updateHero(hero)
    }

    override suspend fun insertHeros(localSuperheros: List<LocalHero>){
        dao.insertAllList(localSuperheros)
    }

}
