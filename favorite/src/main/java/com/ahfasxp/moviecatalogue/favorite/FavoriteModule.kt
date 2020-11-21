package com.ahfasxp.moviecatalogue.favorite

import com.ahfasxp.moviecatalogue.favorite.favoriteMovie.FavoriteMovieViewModel
import com.ahfasxp.moviecatalogue.favorite.favoriteTvshow.FavoriteShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteShowViewModel(get()) }
}