package com.ahfasxp.moviecatalogue.ui.tvShow

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.data.source.CatalogueRepository
import com.ahfasxp.moviecatalogue.utils.DataDummy

class ShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvshow(): List<MainEntity> = catalogueRepository.getAllShows()
}