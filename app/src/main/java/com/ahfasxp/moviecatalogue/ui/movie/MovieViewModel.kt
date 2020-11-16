package com.ahfasxp.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.data.source.CatalogueRepository
import com.ahfasxp.moviecatalogue.utils.DataDummy

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getMovies(): List<MainEntity> = catalogueRepository.getAllMovies()
}