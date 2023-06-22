package com.example.practica_android_superpoderes.data.remote

import com.example.practica_android_superpoderes.data.remote.response.DataBaseComicResponse
import com.example.practica_android_superpoderes.data.remote.response.DataBaseResponse
import com.example.practica_android_superpoderes.data.remote.response.MarvelBaseResponse

interface RemoteDataSource {
    suspend fun getHeros(): MarvelBaseResponse<DataBaseResponse>

    suspend fun getHeroComics(id: String): MarvelBaseResponse<DataBaseComicResponse>

//    suspend fun updateHeroFav(heroId: String)

}
