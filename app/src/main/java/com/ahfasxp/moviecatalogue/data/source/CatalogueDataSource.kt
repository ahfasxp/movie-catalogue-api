package com.ahfasxp.moviecatalogue.data.source

import com.ahfasxp.moviecatalogue.data.MainEntity

interface CatalogueDataSource {
    fun getAllMovies(): List<MainEntity>

    fun getAllShows(): List<MainEntity>

    fun getDetailMovie(id: String): MainEntity

    fun getDetailShow(id: String): MainEntity
}