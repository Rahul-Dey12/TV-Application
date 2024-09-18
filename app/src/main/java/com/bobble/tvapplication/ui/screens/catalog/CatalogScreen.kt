package com.bobble.tvapplication.ui.screens.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.Carousel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.bobble.tvapplication.R
import com.bobble.tvapplication.data.model.Movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun CatalogScreen(
    catalogViewModel: CatalogViewModel,
    modifier: Modifier = Modifier
) {
    val categoryList by catalogViewModel.categories.collectAsState()
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 48.dp, vertical = 32.dp)
    ) {
        item {
            val featuredMovieList by catalogViewModel.featuredMovieList.collectAsState()
            Carousel(
                itemCount = featuredMovieList.size,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(376.dp)
            ) { index ->
                val featuredMovie = featuredMovieList[index]
                val backgroundColor = MaterialTheme.colorScheme.background
                Box {
                    AsyncImage(
                        model = featuredMovie.backgroundImagerUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(
                            R.drawable.placeholder
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .drawBehind {
                                val brush = Brush.horizontalGradient(
                                    listOf(backgroundColor, Color.Transparent)
                                )
                                drawRect(brush)
                            },
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                        ) {
                            Text(featuredMovie.title)
                        }
                    }
                }
            }
        }
        items(categoryList) { category ->
            Text(text = category.name)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(category.movieList) { movie ->
                    MovieCard(
                        movie = movie
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieCard(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: (Movie) -> Unit = {}
) {
    Card(
        onClick = { onClick(movie) },
        modifier = modifier
            .widthIn(max = 320.dp)
            .aspectRatio(16f / 9f),
    ) {
        AsyncImage(
            model = movie.posterUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.placeholder)
        )
    }
}

