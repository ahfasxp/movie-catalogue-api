package com.ahfasxp.moviecatalogue.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase

class ShowViewModel(catalogueUseCase: CatalogueUseCase) : ViewModel() {
    val getTvshow = catalogueUseCase.getAllShows().asLiveData()
}