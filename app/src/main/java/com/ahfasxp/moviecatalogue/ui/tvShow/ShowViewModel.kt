package com.ahfasxp.moviecatalogue.ui.tvShow

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.CatalogueRepository

class ShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvshow(): List<MainEntity> = catalogueRepository.getAllShows()
}