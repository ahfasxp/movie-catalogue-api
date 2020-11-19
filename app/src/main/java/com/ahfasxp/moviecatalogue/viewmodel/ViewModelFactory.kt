package com.ahfasxp.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.di.Injection
import com.ahfasxp.moviecatalogue.ui.detail.DetailViewModel
import com.ahfasxp.moviecatalogue.ui.favorite.favoriteMovie.FavoriteMovieViewModel
import com.ahfasxp.moviecatalogue.ui.favorite.favoriteTvshow.FavoriteShowViewModel
import com.ahfasxp.moviecatalogue.ui.movie.MovieViewModel
import com.ahfasxp.moviecatalogue.ui.tvShow.ShowViewModel

class ViewModelFactory private constructor(private val mCatalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(ShowViewModel::class.java) -> {
                return ShowViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                return FavoriteMovieViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteShowViewModel::class.java) -> {
                return FavoriteShowViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}