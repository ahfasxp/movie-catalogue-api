package com.ahfasxp.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity

interface CatalogueDataSource {
    fun getAllMovies(): LiveData<List<MainEntity>>

    fun getAllShows(): LiveData<List<MainEntity>>

    fun getDetailMovie(id: String): LiveData<MainEntity>

    fun getDetailShow(id: String): LiveData<MainEntity>
}