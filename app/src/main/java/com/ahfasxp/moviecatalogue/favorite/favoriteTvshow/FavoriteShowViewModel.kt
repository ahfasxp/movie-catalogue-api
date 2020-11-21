package com.ahfasxp.moviecatalogue.favorite.favoriteTvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase

class FavoriteShowViewModel(catalogueUseCase: CatalogueUseCase) : ViewModel() {
    val getFavoriteShow = catalogueUseCase.getFavoriteShow()
}