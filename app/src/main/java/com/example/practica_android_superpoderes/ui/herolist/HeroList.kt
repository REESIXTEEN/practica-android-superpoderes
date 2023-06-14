package com.example.practica_android_superpoderes.ui.herolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.practica_android_superpoderes.R
import com.example.practica_android_superpoderes.ui.theme.PracticaandroidsuperpoderesTheme

class HeroListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaandroidsuperpoderesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroList()
                }
            }
        }
    }
}

@Composable
fun HeroList() {

}


@Composable
fun ImageHero(photo: String) {
    AsyncImage(
        model = photo,
        modifier = Modifier.fillMaxWidth().height(300.dp),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.baseline_person),
        contentDescription = "")
}

@Composable
fun HeroName(name: String) {
    Text(
        text = name
    )
}

@Composable
fun HeroDescription(description: String) {
    Text(
        text = description
    )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailPreview() {
    PracticaandroidsuperpoderesTheme {
        HeroList()
    }
}