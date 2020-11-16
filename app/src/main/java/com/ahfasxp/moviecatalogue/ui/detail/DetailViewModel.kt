package com.ahfasxp.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.CatalogueRepository

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getMovie(): LiveData<MainEntity> = catalogueRepository.getDetailMovie(id)

    fun getShow(): LiveData<MainEntity> = catalogueRepository.getDetailShow(id)
}