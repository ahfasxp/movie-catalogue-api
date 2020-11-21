package com.ahfasxp.moviecatalogue.di

import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueInteractor
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.ahfasxp.moviecatalogue.detail.DetailViewModel
import com.ahfasxp.moviecatalogue.movie.MovieViewModel
import com.ahfasxp.moviecatalogue.tvShow.ShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CatalogueUseCase> { CatalogueInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { ShowViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}