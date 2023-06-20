package com.example.practica_android_superpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.practica_android_superpoderes.ui.detail.DetailViewModel
import com.example.practica_android_superpoderes.ui.herolist.HeroListViewModel
import com.example.practica_android_superpoderes.ui.navigation.NavigationGraph
import com.example.practica_android_superpoderes.ui.theme.PracticaandroidsuperpoderesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val heroListViewModel: HeroListViewModel by viewModels()
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaandroidsuperpoderesTheme {
                NavigationGraph(heroListViewModel,detailViewModel)
            }
        }
    }
}