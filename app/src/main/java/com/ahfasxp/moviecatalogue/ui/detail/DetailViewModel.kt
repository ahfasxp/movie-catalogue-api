package com.ahfasxp.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.vo.Resource

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getMovie(): LiveData<Resource<MainEntity>> = catalogueRepository.getDetailMovie(id)

    fun getShow(): LiveData<Resource<MainEntity>> = catalogueRepository.getDetailShow(id)

    fun setFavorite(main: MainEntity, newStatus: Boolean) =
        catalogueRepository.setFavorite(main, newStatus)
}