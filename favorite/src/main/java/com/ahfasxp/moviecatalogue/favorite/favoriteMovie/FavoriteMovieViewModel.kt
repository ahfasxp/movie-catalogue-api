package com.ahfasxp.moviecatalogue.favorite.favoriteMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase

class FavoriteMovieViewModel(catalogueUseCase: CatalogueUseCase) : ViewModel() {
    val getFavoriteMovie = catalogueUseCase.getFavoriteMovie().asLiveData()
}