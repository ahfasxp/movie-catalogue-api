package com.ahfasxp.moviecatalogue.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.di.Injection
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.ahfasxp.moviecatalogue.detail.DetailViewModel
import com.ahfasxp.moviecatalogue.favorite.favoriteMovie.FavoriteMovieViewModel
import com.ahfasxp.moviecatalogue.favorite.favoriteTvshow.FavoriteShowViewModel
import com.ahfasxp.moviecatalogue.movie.MovieViewModel
import com.ahfasxp.moviecatalogue.tvShow.ShowViewModel

class ViewModelFactory private constructor(private val catalogueUseCase: CatalogueUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideCatalogueUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(catalogueUseCase) as T
            }
            modelClass.isAssignableFrom(ShowViewModel::class.java) -> {
                return ShowViewModel(catalogueUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                return FavoriteMovieViewModel(catalogueUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteShowViewModel::class.java) -> {
                return FavoriteShowViewModel(catalogueUseCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(catalogueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}