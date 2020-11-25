package com.ahfasxp.moviecatalogue.core.data

import android.util.Log
import com.ahfasxp.moviecatalogue.core.data.source.local.LocalDataSource
import com.ahfasxp.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ShowResponse
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.domain.repository.ICatalogueRepository
import com.ahfasxp.moviecatalogue.core.utils.AppExecutors
import com.ahfasxp.moviecatalogue.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CatalogueRepository(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ICatalogueRepository {
    override fun getAllMovies(): Flow<Resource<List<Catalogue>>> =
        object : NetworkBoundResource<List<Catalogue>, List<MovieResponse>>() {
            public override fun loadFromDB(): Flow<List<Catalogue>> {
                return localDataSource.getAllMovies().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Catalogue>?): Boolean =
//                data == null || data.isEmpty()
                true //agar selelu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesMovieToEntities(data)
                Log.d("cekmovie", movieList.toString())
                localDataSource.insertCatalogue(movieList)
            }
        }.asFlow()

    override fun getAllShows(): Flow<Resource<List<Catalogue>>> =
        object : NetworkBoundResource<List<Catalogue>, List<ShowResponse>>() {
            public override fun loadFromDB(): Flow<List<Catalogue>> {
                return localDataSource.getAllShows().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Catalogue>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ShowResponse>>> =
                remoteDataSource.getAllShows()

            override suspend fun saveCallResult(data: List<ShowResponse>) {
                val showList = DataMapper.mapResponsesShowToEntities(data)
                localDataSource.insertCatalogue(showList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Catalogue>> {
        return localDataSource.getFavoriteMovie().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun getFavoriteShow(): Flow<List<Catalogue>> {
        return localDataSource.getFavoriteShow().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavorite(catalogue: Catalogue, state: Boolean) {
        val mainEntity = DataMapper.mapDomainToEntity(catalogue)
        appExecutors.diskIO().execute { localDataSource.setFavorite(mainEntity, state) }
    }
}