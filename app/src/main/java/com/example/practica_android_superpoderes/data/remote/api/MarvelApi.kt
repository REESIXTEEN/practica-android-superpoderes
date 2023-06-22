package com.example.practica_android_superpoderes.data.remote.api

import com.example.practica_android_superpoderes.data.remote.response.DataBaseComicResponse
import com.example.practica_android_superpoderes.data.remote.response.DataBaseResponse
import com.example.practica_android_superpoderes.data.remote.response.MarvelBaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    suspend fun getHeros(@Query("apikey") apikey: String, @Query("hash") hash: String, @Query("ts") ts: Int, @Query("limit") limit: Int): MarvelBaseResponse<DataBaseResponse>

    @GET("characters/{id}/comics")
    suspend fun getHeroComics(@Path("id")id:String, @Query("apikey") apikey: String, @Query("hash") hash: String, @Query("ts") ts: Int, @Query("limit") limit: Int): MarvelBaseResponse<DataBaseComicResponse>



}