package com.bobble.tvapplication.data.repo

import com.bobble.tvapplication.data.model.Category
import com.bobble.tvapplication.data.model.Movie
import kotlinx.coroutines.delay

class MovieRepository {

    private val categories = listOf(
        "Action & Adventure",
        "Comedy",
        "Crime",
        "Kids"
    )

    private val movies = listOf(
        Movie(
            id = 1,
            title = "Late Night with Seth Meyers",
            posterUrl = "https://image.tmdb.org/t/p/original/g6MrJxNaHYGYU7Sxo72e5B8gKOV.jpg",
            backgroundImagerUrl = "https://image.tmdb.org/t/p/original/dfX2UaHVE5c7kLBFbgmEZJuy4Ev.jpg"
        ),
        Movie(
            id = 2,
            title = "Goede Tijden, Slechte Tijden",
            posterUrl = "https://image.tmdb.org/t/p/original/t6jVlbPMtZOJoAOfeoR4yQmnjXM.jpg",
            backgroundImagerUrl = "https://image.tmdb.org/t/p/original//gMMnf8VRg3Z98WaFmOLr9Jk8pIs.jpg"
        ),
        Movie(
            id = 3,
            title = "Un si grand soleil",
            posterUrl = "https://image.tmdb.org/t/p/original/t6jVlbPMtZOJoAOfeoR4yQmnjXM.jpg",
            backgroundImagerUrl = "https://image.tmdb.org/t/p/original/rj3jBAZwPiOgkwAy1205MAgLahj.jpg"
        ),
        Movie(
            id = 4,
            title = "The Late Show with Stephen Colbert",
            posterUrl = "https://image.tmdb.org/t/p/original/9jkThAGYj2yp8jsS6Nriy5mzKFT.jpg",
            backgroundImagerUrl = "https://image.tmdb.org/t/p/original/gMMnf8VRg3Z98WaFmOLr9Jk8pIs.jpg"
        ),
        Movie(
            id = 5,
            title = "Late Show with David Letterman",
            posterUrl = "https://image.tmdb.org/t/p/original/7dwM8AKyQfauguoQbI1MIlHinLM.jpg",
            backgroundImagerUrl = "https://image.tmdb.org/t/p/original/7jEnft2CLNbILWAiBRIBrXNN7Qh.jpg"
        )
    )

    fun getCategories(): List<String> {
        return categories
    }

    fun getMovieListByCategory(category: String): List<Movie> {
        return movies.shuffled()
    }

    fun getFeaturedMovieList(): List<Movie>{
        return movies
    }
}