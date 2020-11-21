package com.ahfasxp.moviecatalogue.core.data.source.local

import androidx.lifecycle.LiveData
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.data.source.local.room.CatalogueDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

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