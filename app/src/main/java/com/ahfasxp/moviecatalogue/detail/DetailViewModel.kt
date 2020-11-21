package com.ahfasxp.moviecatalogue.detail

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase

class DetailViewModel(private val catalogueUseCase: CatalogueUseCase) : ViewModel() {
    fun setFavorite(catalogue: Catalogue, newStatus: Boolean) =
        catalogueUseCase.setFavorite(catalogue, newStatus)
}