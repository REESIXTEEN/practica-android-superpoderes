package com.example.practica_android_superpoderes.data

import com.example.practica_android_superpoderes.data.local.LocalDataSourceImpl
import com.example.practica_android_superpoderes.data.mappers.LocalToPresentationMapper
import com.example.practica_android_superpoderes.data.mappers.PresentationToLocalMapper
import com.example.practica_android_superpoderes.data.mappers.RemoteToLocalMapper
import com.example.practica_android_superpoderes.data.remote.RemoteDataSourceImpl
import com.example.practica_android_superpoderes.ui.model.Comic
import com.example.practica_android_superpoderes.ui.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
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

    override suspend fun getHeros(): Flow<List<Hero>> {
        if (localDataSource.getCount() == 0) {
            val remoteSuperheros = remoteDataSource.getHeros()
            localDataSource.insertHeros(remoteToLocalMapper.mapGetHeroResponse(remoteSuperheros))
        }
        return localToPresentationMapper.mapLocalSuperheros(localDataSource.getHeros())
    }

    override suspend fun getHero(id: String): Flow<Hero> {
        return localToPresentationMapper.mapLocalSuperhero(localDataSource.getHero(id))
    }


    override suspend fun getComics(id: String): List<Comic> {
        val remoteSuperheros = remoteDataSource.getHeroComics(id)
        return remoteToLocalMapper.mapGetHeroComicsResponse(remoteSuperheros)
    }


    override suspend fun updateHero(hero: Hero) {
        val localHero = presentationToLocalMapper.mapPresentationHero(hero)
        localDataSource.updateHero(localHero)
    }


}