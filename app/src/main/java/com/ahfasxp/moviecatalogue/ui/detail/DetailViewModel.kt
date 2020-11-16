package com.ahfasxp.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.data.source.CatalogueRepository
import com.ahfasxp.moviecatalogue.utils.DataDummy

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getMovie(): MainEntity = catalogueRepository.getDetailMovie(id)

    fun getShow(): MainEntity = catalogueRepository.getDetailShow(id)
}