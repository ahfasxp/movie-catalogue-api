package com.ahfasxp.moviecatalogue.ui.favorite.favoriteTvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity

class FavoriteShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getFavoriteShow(): LiveData<List<MainEntity>> {
        return catalogueRepository.getFavoriteShow()
    }
}