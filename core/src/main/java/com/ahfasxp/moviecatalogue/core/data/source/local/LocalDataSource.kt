package com.ahfasxp.moviecatalogue.core.data.source.local

import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.data.source.local.room.CatalogueDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mCatalogueDao: CatalogueDao) {
    fun getAllMovies(): Flow<List<MainEntity>> = mCatalogueDao.getMovies()

    fun getAllShows(): Flow<List<MainEntity>> = mCatalogueDao.getShows()

    fun getFavoriteMovie(): Flow<List<MainEntity>> = mCatalogueDao.getFavoriteMovie()

    fun getFavoriteShow(): Flow<List<MainEntity>> = mCatalogueDao.getFavoriteShow()

    suspend fun insertCatalogue(main: List<MainEntity>) = mCatalogueDao.insertCatalogue(main)

    fun setFavorite(main: MainEntity, newState: Boolean) {
        main.isFavorite = newState
        mCatalogueDao.updateCatalogue(main)
    }
}