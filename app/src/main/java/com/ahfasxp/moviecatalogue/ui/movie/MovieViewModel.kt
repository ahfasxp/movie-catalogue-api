package com.ahfasxp.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.vo.Resource

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<MainEntity>>> = catalogueRepository.getAllMovies()
}