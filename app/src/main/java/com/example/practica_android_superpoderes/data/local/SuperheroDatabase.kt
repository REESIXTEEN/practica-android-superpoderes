package com.example.practica_android_superpoderes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practica_android_superpoderes.data.local.model.LocalHero

@Database(entities = [LocalHero::class], version = 1)
abstract class SuperheroDatabase : RoomDatabase() {
    abstract fun superheroDao(): SuperheroDAO
}
