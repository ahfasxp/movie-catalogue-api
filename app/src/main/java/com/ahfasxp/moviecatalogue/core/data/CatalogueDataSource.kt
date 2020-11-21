package com.ahfasxp.moviecatalogue.core.data

import androidx.lifecycle.LiveData
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.vo.Resource

interface CatalogueDataSource {
    fun getAllMovies(): LiveData<Resource<List<Catalogue>>>

    fun getAllShows(): LiveData<Resource<List<Catalogue>>>

    fun getDetailMovie(id: String): LiveData<Resource<MainEntity>>

    fun getDetailShow(id: String): LiveData<Resource<MainEntity>>

    fun getFavoriteMovie(): LiveData<List<Catalogue>>

    fun getFavoriteShow(): LiveData<List<Catalogue>>

    fun setFavorite(main: Catalogue, state: Boolean)
}