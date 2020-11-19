package com.ahfasxp.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.vo.Resource

interface CatalogueDataSource {
    fun getAllMovies(): LiveData<Resource<List<MainEntity>>>

    fun getAllShows(): LiveData<Resource<List<MainEntity>>>

    fun getDetailMovie(id: String): LiveData<Resource<MainEntity>>

    fun getDetailShow(id: String): LiveData<Resource<MainEntity>>

    fun getFavoriteMovie(): LiveData<List<MainEntity>>

    fun getFavoriteShow(): LiveData<List<MainEntity>>

    fun setFavorite(main: MainEntity, state: Boolean)
}