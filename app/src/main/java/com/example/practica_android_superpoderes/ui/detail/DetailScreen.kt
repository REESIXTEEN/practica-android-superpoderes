package com.example.practica_android_superpoderes.ui.detail


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.practica_android_superpoderes.ui.model.Comic
import com.example.practica_android_superpoderes.ui.model.Hero
import com.example.practica_android_superpoderes.ui.theme.PracticaandroidsuperpoderesTheme

@Composable
fun DetailScreen (viewModel: DetailViewModel, idHero: String) {

    viewModel.getHero(idHero)
    viewModel.getHeroComics(idHero)
    val hero by viewModel.hero.collectAsState()
    val comics by viewModel.comics.collectAsState()

    DetailContent(hero,comics){viewModel.updateFav()}
}

@Composable
fun DetailContent(hero: Hero,comics: List<Comic>, updateFav: () -> Unit) {

    Column(modifier = Modifier.padding(8.dp).verticalScroll(rememberScrollState())) {
        ImageHero(photo = hero.photo)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement  =  Arrangement.SpaceBetween
        ) {
            Column(Modifier.weight(1f)){
                HeroName(name = hero.name)
            }
            Column(Modifier){
                HeroFav(hero.favorite,updateFav)
            }

        }
        HeroDescription(description = hero.description)
        HeroComics(comics = comics)
    }
}

@Composable
fun HeroComics(comics: List<Comic>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(comics) { comic ->
            ComicItem(comic = comic)
        }
    }
}


@Composable
fun ComicItem(comic: Comic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(300.dp)
            .width(200.dp)
    ) {
        AsyncImage(
            model = comic.photo,
            contentDescription = "${comic.name} photo",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            placeholder = painterResource(id = R.drawable.baseline_person),
            contentScale = ContentScale.Crop
        )
        Text(text = comic.name,
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 1,
            modifier = Modifier.padding(8.dp))
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
        ),
        maxLines = 2,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun HeroFav(isFav: Boolean, updateFav: () -> Unit) {

    val imageVector = if (isFav) {
        Icons.Default.Favorite
    } else {
        Icons.Default.FavoriteBorder
    }

    Icon(
        imageVector = imageVector,
        contentDescription = "Icono de corazón",
        tint = Color.Red,
        modifier = Modifier
            .size(44.dp)
            .clickable {
                updateFav()
            }
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
        val hero = Hero(0, "IronwgrbgabeabgeabadfbasrgabaedfnbadbaMan", "Description","",false)
        val comics = listOf<Comic>(Comic(1,"comic1",""),Comic(2,"comic2",""))
        DetailContent(hero,comics){}
    }
}