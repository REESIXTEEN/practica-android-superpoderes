package com.example.practica_android_superpoderes.data.mappers

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import com.example.practica_android_superpoderes.ui.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun mapLocalSuperheros(localSuperheros: Flow<List<LocalHero>>): Flow<List<Hero>> {
        return localSuperheros.map { localHeroList ->
            localHeroList.map {mapLocalSuperhero(it)}
        }
    }

    fun mapLocalSuperhero(localSuperhero: Flow<LocalHero>): Flow<Hero> {
        return localSuperhero.map { localHero ->
            mapLocalSuperhero(localHero)
        }
    }

    fun mapLocalSuperhero(getHerosResponse: LocalHero): Hero {
        return Hero(getHerosResponse.id, getHerosResponse.name, getHerosResponse.description, getHerosResponse.photo, getHerosResponse.favorite)
    }

}
