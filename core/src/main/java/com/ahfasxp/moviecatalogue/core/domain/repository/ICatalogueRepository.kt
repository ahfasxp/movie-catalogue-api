package com.ahfasxp.moviecatalogue.core.domain.repository

import com.ahfasxp.moviecatalogue.core.data.Resource
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import kotlinx.coroutines.flow.Flow

interface ICatalogueRepository {
    fun getAllMovies(): Flow<Resource<List<Catalogue>>>

    fun getAllShows(): Flow<Resource<List<Catalogue>>>

    fun getFavoriteMovie(): Flow<List<Catalogue>>

    fun getFavoriteShow(): Flow<List<Catalogue>>

    fun setFavorite(catalogue: Catalogue, state: Boolean)
}