package com.ahfasxp.moviecatalogue.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.ahfasxp.moviecatalogue.core.vo.Resource

class ShowViewModel(catalogueUseCase: CatalogueUseCase) : ViewModel() {
    val getTvshow = catalogueUseCase.getAllShows()
}