package com.ahfasxp.moviecatalogue.core.domain.repository

import androidx.lifecycle.LiveData
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface ICatalogueRepository {
    fun getAllMovies(): Flow<Resource<List<Catalogue>>>

    fun getAllShows(): Flow<Resource<List<Catalogue>>>

    fun getFavoriteMovie(): Flow<List<Catalogue>>

    fun getFavoriteShow(): Flow<List<Catalogue>>

    fun setFavorite(main: Catalogue, state: Boolean)
}