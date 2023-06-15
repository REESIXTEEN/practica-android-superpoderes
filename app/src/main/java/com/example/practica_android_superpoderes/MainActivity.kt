package com.example.practica_android_superpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica_android_superpoderes.ui.navigation.NavigationGraph
import com.example.practica_android_superpoderes.ui.theme.PracticaandroidsuperpoderesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaandroidsuperpoderesTheme {
                NavigationGraph(loginViewModel, superHeroListViewModel)
            }
        }
    }
}