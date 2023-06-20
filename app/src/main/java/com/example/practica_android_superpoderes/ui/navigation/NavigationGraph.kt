package com.example.practica_android_superpoderes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practica_android_superpoderes.ui.detail.DetailScreen
import com.example.practica_android_superpoderes.ui.detail.DetailViewModel
import com.example.practica_android_superpoderes.ui.herolist.HeroListScreen
import com.example.practica_android_superpoderes.ui.herolist.HeroListViewModel

@Composable
fun NavigationGraph(heroListViewModel: HeroListViewModel, detailViewModel: DetailViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HeroListScreen.route) {
        composable(Screens.HeroListScreen.route) {
            HeroListScreen(viewModel = heroListViewModel) {
                navController.navigate(Screens.DetailListScreen.createRouteWithArgs(it.id))
            }
        }

        composable(Screens.DetailListScreen.route, arguments = listOf(
            navArgument(Screens.DetailListScreen.ARG_IDHERO){
                this.type = NavType.StringType
            })) {
            val idHero = it.arguments?.getString(Screens.DetailListScreen.ARG_IDHERO)
            if (idHero != null){
                DetailScreen(viewModel = detailViewModel, idHero)
            } else {
                navController.navigateUp()
            }
        }
    }
}

