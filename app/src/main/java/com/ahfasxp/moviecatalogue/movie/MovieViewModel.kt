package com.ahfasxp.moviecatalogue.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase

class MovieViewModel(catalogueUseCase: CatalogueUseCase) : ViewModel() {
    val getMovies = catalogueUseCase.getAllMovies().asLiveData()
}