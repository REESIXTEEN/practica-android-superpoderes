package com.example.practica_android_superpoderes.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practica_android_superpoderes.ui.detail.DetailScreen
import com.example.practica_android_superpoderes.ui.herolist.HeroListScreen
import com.example.practica_android_superpoderes.ui.herolist.HeroListViewModel

@Composable
fun NavigationGraph(heroListViewModel: HeroListViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HeroListScreen.route) {
        composable(Screens.HeroListScreen.route) {
            HeroListScreen(viewModel = heroListViewModel) {
                navController.navigate(Screens.DetailListScreen.route)
            }
        }

//        composable(Screens.DetailListScreen.route) {
//            DetailScreen(viewModel = detailViewModel)
//        }
    }
}

