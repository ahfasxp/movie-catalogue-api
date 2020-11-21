package com.ahfasxp.moviecatalogue.core.domain.usecase

import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface CatalogueUseCase {
    fun getAllMovies(): Flow<Resource<List<Catalogue>>>

    fun getAllShows(): Flow<Resource<List<Catalogue>>>

    fun getFavoriteMovie(): Flow<List<Catalogue>>

    fun getFavoriteShow(): Flow<List<Catalogue>>

    fun setFavorite(main: Catalogue, state: Boolean)
}