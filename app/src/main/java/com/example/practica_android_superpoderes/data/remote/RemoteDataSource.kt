package com.example.practica_android_superpoderes.data.remote

import com.example.practica_android_superpoderes.data.remote.request.HeroFavRequestBody
import com.example.practica_android_superpoderes.data.remote.response.GetHerosResponse

interface RemoteDataSource {
    suspend fun getHeros(): List<GetHerosResponse>

    suspend fun updateHeroFav(heroId: String)

}
