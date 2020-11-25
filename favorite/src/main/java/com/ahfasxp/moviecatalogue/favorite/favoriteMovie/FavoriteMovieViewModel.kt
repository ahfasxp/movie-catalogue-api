package com.ahfasxp.moviecatalogue.favorite.favoriteMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase

class FavoriteMovieViewModel(catalogueUseCase: CatalogueUseCase) : ViewModel() {
    val getFavoriteMovie = catalogueUseCase.getFavoriteMovie().asLiveData()
}