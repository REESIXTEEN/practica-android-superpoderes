package com.example.practica_android_superpoderes.ui.navigation

//import com.example.practica_android_superpoderes.ui.navigation.Screens.Screen3.ARG_DATE
//import com.example.practica_android_superpoderes.ui.navigation.Screens.Screen3.ARG_NAME

sealed class Screens(val route: String) {
    object HeroListScreen: Screens(SCREEN1_BASE_ROUTE)
    object DetailListScreen: Screens(SCREEN2_BASE_ROUTE)
//    object Screen3: Screens( SCREEN3_ROUTE_TEMPLATE){
//        const val ARG_NAME = "myText"
//        const val ARG_DATE = "date"
//
//        fun createRouteWithArgs(name: String, date: Int? = null): String {
//            return SCREEN3_ROUTE_TO_FORMAT.format(name, date)
//        }
//    }

    companion object {
        private const val SCREEN1_BASE_ROUTE = "HeroListScreen"
        private const val SCREEN2_BASE_ROUTE = "DetailListScreen"
        private const val SCREEN3_BASE_ROUTE = "Screen3"
//        private const val SCREEN3_ROUTE_TEMPLATE = "$SCREEN3_BASE_ROUTE/{$ARG_NAME}?$ARG_DATE={$ARG_DATE}"
//        private const val SCREEN3_ROUTE_TO_FORMAT = "$SCREEN3_BASE_ROUTE/%s?$ARG_DATE=%d"
    }
}
