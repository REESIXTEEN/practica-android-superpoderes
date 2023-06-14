package com.example.practica_android_superpoderes.data.mappers

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import com.example.practica_android_superpoderes.ui.model.Hero
import javax.inject.Inject

class PresentationToLocalMapper @Inject constructor() {

    fun mapPresentationHero(hero: Hero): LocalHero {
        return LocalHero(hero.id, hero.name, hero.description, hero.photo, hero.favorite)
    }

}
