package com.example.practica_android_superpoderes.data.remote

import com.example.practica_android_superpoderes.data.remote.request.HeroFavRequestBody
import com.example.practica_android_superpoderes.data.remote.response.DataBaseResponse
import com.example.practica_android_superpoderes.data.remote.response.GetHerosResponse
import com.example.practica_android_superpoderes.data.remote.response.MarvelBaseResponse

interface RemoteDataSource {
    suspend fun getHeros(): MarvelBaseResponse<DataBaseResponse>

//    suspend fun updateHeroFav(heroId: String)

}
