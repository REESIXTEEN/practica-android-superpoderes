package com.example.practica_android_superpoderes.ui.model

data class Hero(
    val id: String,
    val name: String,
    val description: String,
    val photo: String,
    var favorite : Boolean
)