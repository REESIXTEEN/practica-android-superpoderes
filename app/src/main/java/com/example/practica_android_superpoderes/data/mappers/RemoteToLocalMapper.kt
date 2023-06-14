package com.example.practica_android_superpoderes.data.mappers

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import com.example.practica_android_superpoderes.data.remote.response.GetHerosResponse
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor(){

    fun mapGetHeroResponse(getHerosResponses: List<GetHerosResponse>): List<LocalHero> {
        return getHerosResponses.map { mapGetHeroResponse(it) }
    }

    fun mapGetHeroResponse(getHerosResponse: GetHerosResponse): LocalHero {
        return LocalHero(getHerosResponse.id, getHerosResponse.name,getHerosResponse.description,getHerosResponse.photo, false)
    }

}
