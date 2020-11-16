package com.ahfasxp.moviecatalogue.di

import android.content.Context
import com.ahfasxp.moviecatalogue.data.source.CatalogueRepository
import com.ahfasxp.moviecatalogue.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return CatalogueRepository.getInstance(remoteDataSource)
    }
}