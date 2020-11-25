package com.ahfasxp.moviecatalogue.favorite.favoriteTvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase

class FavoriteShowViewModel(catalogueUseCase: CatalogueUseCase) : ViewModel() {
    val getFavoriteShow = catalogueUseCase.getFavoriteShow().asLiveData()
}