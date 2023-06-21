package com.example.practica_android_superpoderes.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.practica_android_superpoderes.data.local.model.LocalHero
import kotlinx.coroutines.flow.Flow


@Dao
interface SuperheroDAO {

    @Query("SELECT * FROM superheros")
    fun getAll(): Flow<List<LocalHero>>

    @Query("SELECT * FROM superheros WHERE id = :id")
    fun getHero(id: String): Flow<LocalHero>

    @Query("SELECT COUNT(*) FROM superheros")
    suspend fun getCount(): Int

    @Update
    suspend fun updateHero(hero: LocalHero)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVararg(vararg users: LocalHero)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllList(users: List<LocalHero>)

    @Delete
    suspend fun delete(user: LocalHero)
}
