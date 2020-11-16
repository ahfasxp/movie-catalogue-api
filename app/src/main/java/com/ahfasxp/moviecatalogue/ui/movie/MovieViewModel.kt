package com.ahfasxp.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.CatalogueRepository

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getMovies(): List<MainEntity> = catalogueRepository.getAllMovies()
}