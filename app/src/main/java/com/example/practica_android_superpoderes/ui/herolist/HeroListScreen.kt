package com.example.practica_android_superpoderes.ui.herolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.practica_android_superpoderes.ui.model.Hero
import com.example.practica_android_superpoderes.ui.theme.PracticaandroidsuperpoderesTheme

@Composable
fun HeroListScreen(viewModel: HeroListViewModel, onHeroListClicked: (Hero) -> (Unit)) {

    val heros by viewModel.heros.collectAsState()
    HeroListContent(heros, onHeroListClicked)

}

@Composable
fun HeroListContent(heros: List<Hero> , onHeroListClicked: (Hero) -> Unit) {

    val scaffoldS = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopBar()
        },
        bottomBar = {
            MyBottomBar()
        },
        content = {
            LazyColumn(
                Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = it) {
                items(heros) { hero ->
                    HeroItem(hero = hero, onHeroClick = onHeroListClicked)
                }
            }
        }
    )
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier, onHeroClick: (Hero) -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp).clickable { onHeroClick(hero) }
    ) {
        AsyncImage(
            model = hero.photo,
            contentDescription = "${hero.name} photo",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )
        Text(text = hero.name, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(8.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    CenterAlignedTopAppBar(title = {
        Text(text = "Listado Heroes")
    })
}

@Composable
fun BottomBarItem(text: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = icon, contentDescription = icon.name)
        Text(text = text)
    }
}

@Composable
fun MyBottomBar() {
    BottomAppBar() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            BottomBarItem("Home", Icons.Default.Home)
            BottomBarItem("Favs", Icons.Default.Favorite)
            BottomBarItem("Settings", Icons.Default.Settings)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeroListPreview() {
    PracticaandroidsuperpoderesTheme {
        val heros = listOf<Hero>(
            Hero("1","IronMan","Description","",true),
            Hero("2","SpiderMan","Description","",false)
        )
        HeroListContent(heros) { }
    }
}

@Preview
@Composable
fun MyTopBar_Preview() {
    MyTopBar()
}

@Preview
@Composable
fun BottomBarItem_Preview() {
    BottomBarItem("Home", Icons.Default.Home)
}