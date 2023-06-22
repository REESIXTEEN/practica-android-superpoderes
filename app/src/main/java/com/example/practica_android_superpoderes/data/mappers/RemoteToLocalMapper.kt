package com.example.practica_android_superpoderes.data.mappers

import com.example.practica_android_superpoderes.data.local.model.LocalHero
import com.example.practica_android_superpoderes.data.remote.response.CharacterComicsResponse
import com.example.practica_android_superpoderes.data.remote.response.CharacterResponse
import com.example.practica_android_superpoderes.data.remote.response.DataBaseComicResponse
import com.example.practica_android_superpoderes.data.remote.response.DataBaseResponse
import com.example.practica_android_superpoderes.data.remote.response.MarvelBaseResponse
import com.example.practica_android_superpoderes.ui.model.Comic
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor(){

    fun mapGetHeroResponse(baseResponse: MarvelBaseResponse<DataBaseResponse>): List<LocalHero> {
        val responseList = baseResponse.data?.characters
        return responseList?.map { mapGetHeroResponse(it) } ?: emptyList()
    }

    fun mapGetHeroResponse(character: CharacterResponse): LocalHero {
        return LocalHero(character.id, character.name,character.description,character.thumbnail.path + "." + character.thumbnail.extension, false)
    }

    fun mapGetHeroComicsResponse(baseResponse: MarvelBaseResponse<DataBaseComicResponse>): List<Comic> {
        val responseList = baseResponse.data?.characters
        return responseList?.map { mapGetHeroComicResponse(it) } ?: emptyList()
    }

    fun mapGetHeroComicResponse(character: CharacterComicsResponse): Comic {
        return Comic(character.id, character.title,character.thumbnail.path + "." + character.thumbnail.extension)
    }

}
