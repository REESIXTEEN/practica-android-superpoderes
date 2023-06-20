package com.example.practica_android_superpoderes.ui.navigation

import com.example.practica_android_superpoderes.ui.navigation.Screens.DetailListScreen.ARG_IDHERO


sealed class Screens(val route: String) {
    object HeroListScreen: Screens(SCREEN1_BASE_ROUTE)
    object DetailListScreen: Screens(SCREEN3_ROUTE_TEMPLATE){
        const val ARG_IDHERO = "idHero"

        fun createRouteWithArgs(idHero: String): String {
            return SCREEN2_ROUTE_TO_FORMAT.format(idHero)
        }

    }

    companion object {
        private const val SCREEN1_BASE_ROUTE = "HeroListScreen"
        private const val SCREEN2_BASE_ROUTE = "DetailListScreen"
        private const val SCREEN3_ROUTE_TEMPLATE = "$SCREEN2_BASE_ROUTE/{$ARG_IDHERO}"
        private const val SCREEN2_ROUTE_TO_FORMAT = "$SCREEN2_BASE_ROUTE/%s"
    }
}
