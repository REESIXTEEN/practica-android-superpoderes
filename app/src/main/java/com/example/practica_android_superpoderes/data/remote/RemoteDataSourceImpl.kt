package com.example.practica_android_superpoderes.data.remote

import android.content.SharedPreferences
import com.example.practica_android_superpoderes.data.remote.api.DragonBallApi
import com.example.practica_android_superpoderes.data.remote.request.GetHerosRequestBody
import com.example.practica_android_superpoderes.data.remote.request.HeroFavRequestBody
import com.example.practica_android_superpoderes.data.remote.response.GetHerosResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val api: DragonBallApi, private val shared: SharedPreferences): RemoteDataSource {

    private val token = "qwerty"

    override suspend fun getHeros(): List<GetHerosResponse> {
        return api.getHeros("Bearer $token", GetHerosRequestBody())
    }

    override suspend fun updateHeroFav(heroId: String) {
        api.updateHeroFav("Bearer $token", HeroFavRequestBody(heroId))
    }

}