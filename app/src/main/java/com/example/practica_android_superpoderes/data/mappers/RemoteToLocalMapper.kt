package com.example.practica_android_superpoderes.data.mappers

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import com.example.practica_android_superpoderes.data.remote.response.CharacterResponse
import com.example.practica_android_superpoderes.data.remote.response.DataBaseResponse
import com.example.practica_android_superpoderes.data.remote.response.GetHerosResponse
import com.example.practica_android_superpoderes.data.remote.response.MarvelBaseResponse
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor(){

//    fun mapGetHeroResponse(getHerosResponses: List<GetHerosResponse>): List<LocalHero> {
//        return getHerosResponses.map { mapGetHeroResponse(it) }
//    }
//
//    fun mapGetHeroResponse(getHerosResponse: GetHerosResponse): LocalHero {
//        return LocalHero(getHerosResponse.id, getHerosResponse.name,getHerosResponse.description,getHerosResponse.photo, getHerosResponse.favorite)
//    }

    fun mapGetHeroResponse(baseResponse: MarvelBaseResponse<DataBaseResponse>): List<LocalHero> {
        val responseList = baseResponse.data?.characters
        return responseList?.map { mapGetHeroResponse(it) } ?: emptyList()
    }

    fun mapGetHeroResponse(character: CharacterResponse): LocalHero {
        return LocalHero(character.id, character.name,character.description,character.thumbnail.path + "." + character.thumbnail.extension, false)
    }

}
