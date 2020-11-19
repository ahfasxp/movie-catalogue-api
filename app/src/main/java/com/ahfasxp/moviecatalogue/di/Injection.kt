package com.ahfasxp.moviecatalogue.di

import android.content.Context
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.data.source.local.LocalDataSource
import com.ahfasxp.moviecatalogue.data.source.local.room.CatalogueDatabase
import com.ahfasxp.moviecatalogue.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.utils.AppExecutors
import com.ahfasxp.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}