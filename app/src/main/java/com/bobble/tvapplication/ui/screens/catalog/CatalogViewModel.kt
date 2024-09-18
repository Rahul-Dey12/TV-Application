package com.bobble.tvapplication.ui.screens.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobble.tvapplication.data.model.Category
import com.bobble.tvapplication.data.model.Movie
import com.bobble.tvapplication.data.repo.MovieRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class CatalogViewModel : ViewModel() {

    private val repository: MovieRepository = MovieRepository()
    val featuredMovieList: StateFlow<List<Movie>> = flow {
        emit(repository.getFeaturedMovieList())
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val categories: StateFlow<List<Category>> = flow {
        var list = listOf<Category>()
        repository.getCategories().forEach {
            val category = Category(
                name = it,
                movieList = repository.getMovieListByCategory(it)
            )
            list = list + listOf(category)
            emit(list)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())
}