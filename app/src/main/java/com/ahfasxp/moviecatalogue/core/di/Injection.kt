package com.ahfasxp.moviecatalogue.core.di

import android.content.Context
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.data.source.local.LocalDataSource
import com.ahfasxp.moviecatalogue.core.data.source.local.room.CatalogueDatabase
import com.ahfasxp.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiConfig
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueInteractor
import com.ahfasxp.moviecatalogue.core.domain.usecase.CatalogueUseCase
import com.ahfasxp.moviecatalogue.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideCatalogueUseCase(context: Context): CatalogueUseCase {
        val repository = provideRepository(context)
        return CatalogueInteractor(repository)
    }
}