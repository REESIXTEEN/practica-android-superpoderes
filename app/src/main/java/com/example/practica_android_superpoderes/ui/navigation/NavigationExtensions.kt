package com.example.practica_android_superpoderes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.composableNew(screens: Screens, content: @Composable (NavBackStackEntry)->(Unit)){
    this.composable(screens.route, content = content)
}
