package com.example.practica_android_superpoderes.data

import com.example.practica_android_superpoderes.data.local.LocalDataSourceImpl
import com.example.practica_android_superpoderes.data.mappers.LocalToPresentationMapper
import com.example.practica_android_superpoderes.data.mappers.PresentationToLocalMapper
import com.example.practica_android_superpoderes.data.mappers.RemoteToLocalMapper
import com.example.practica_android_superpoderes.data.remote.RemoteDataSourceImpl
import com.example.practica_android_superpoderes.ui.model.Hero
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSourceImpl,
    private val remoteDataSource: RemoteDataSourceImpl,
    private val localToPresentationMapper: LocalToPresentationMapper,
    private val remoteToLocalMapper: RemoteToLocalMapper,
    private val presentationToLocalMapper: PresentationToLocalMapper
): Repository{

    override suspend fun getHeros(): List<Hero> {
        if (localDataSource.getHeros().isEmpty()) {
            val remoteSuperheros = remoteDataSource.getHeros()
            localDataSource.insertHeros(remoteToLocalMapper.mapGetHeroResponse(remoteSuperheros))
        }
        return localToPresentationMapper.mapLocalSuperheros(localDataSource.getHeros())
    }

    suspend fun getHero(id: String): Hero {
        return localToPresentationMapper.mapLocalSuperheros(localDataSource.getHero(id)).first()
    }


    suspend fun updateHero(hero: Hero) {
        val localHero = presentationToLocalMapper.mapPresentationHero(hero)
        localDataSource.updateHero(localHero)
        remoteDataSource.updateHeroFav(hero.id)
    }


}