package com.example.practica_android_superpoderes.data.remote

import android.content.SharedPreferences
import com.example.practica_android_superpoderes.data.remote.api.MarvelApi
import com.example.practica_android_superpoderes.data.remote.response.DataBaseResponse
import com.example.practica_android_superpoderes.data.remote.response.DataBaseComicResponse
import com.example.practica_android_superpoderes.data.remote.response.MarvelBaseResponse
import javax.inject.Inject
import javax.inject.Singleton

private const val HASH = "78e85293f475d4a35479bff84e110fca"
private const val APIKEY = "d757693108c7a879f4a5186b86e48d77"

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val api: MarvelApi, private val shared: SharedPreferences): RemoteDataSource {

    override suspend fun getHeros(): MarvelBaseResponse<DataBaseResponse> {
        return api.getHeros(APIKEY,HASH,1,10)
    }

    override suspend fun getHeroComics(id: String): MarvelBaseResponse<DataBaseComicResponse> {
        return api.getHeroComics(id,APIKEY,HASH,1,10)
    }

//    override suspend fun updateHeroFav(heroId: String) {
//        api.updateHeroFav("Bearer $token", HeroFavRequestBody(heroId))
//    }

}