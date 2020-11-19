package com.ahfasxp.moviecatalogue.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.vo.Resource

class ShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvshow(): LiveData<Resource<List<MainEntity>>> = catalogueRepository.getAllShows()
}