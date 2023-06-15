package com.example.practica_android_superpoderes.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.practica_android_superpoderes.R
import com.example.practica_android_superpoderes.ui.theme.PracticaandroidsuperpoderesTheme

class DetailScreen (viewModel: DetailViewModel) {

}

@Composable
fun Detail() {
    Column(Modifier.padding(8.dp)) {
        ImageHero(photo = "")
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement  =  Arrangement.SpaceBetween
        ) {
            HeroName(name = "Goku")
            HeroFav(false)
        }
        HeroDescription(description = "fkjqnwvfnqjqpewnvpjeqnv")
    }
}


@Composable
fun ImageHero(photo: String) {
    AsyncImage(
        model = photo,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.baseline_person),
        contentDescription = "")
}

@Composable
fun HeroName(name: String) {
    Text(
        text = name,
        style = TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun HeroFav(isFav: Boolean) {

    val imageVector = if (isFav) {
        Icons.Default.Favorite
    } else {
        Icons.Default.FavoriteBorder
    }

    Icon(
        imageVector = imageVector,
        contentDescription = "Icono de corazón",
        tint = Color.Red,
        modifier = Modifier.size(44.dp)
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
        Detail()
    }
}