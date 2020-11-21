package com.ahfasxp.moviecatalogue.core.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ahfasxp.moviecatalogue.core.data.source.local.LocalDataSource
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ShowResponse
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.ahfasxp.moviecatalogue.core.domain.repository.ICatalogueRepository
import com.ahfasxp.moviecatalogue.core.utils.AppExecutors
import com.ahfasxp.moviecatalogue.core.utils.DataMapper
import com.ahfasxp.moviecatalogue.core.vo.Resource

class CatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ICatalogueRepository {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<Catalogue>>> =
        object : NetworkBoundResource<List<Catalogue>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<Catalogue>> {
                return Transformations.map(localDataSource.getAllMovies()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Catalogue>?): Boolean =
//                data == null || data.isEmpty()
                true //agar selelu mengambil data dari internet

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesMovieToEntities(data)
                Log.d("cekmovie", movieList.toString())
                localDataSource.insertCatalogue(movieList)
            }
        }.asLiveData()

    override fun getAllShows(): LiveData<Resource<List<Catalogue>>> =
        object : NetworkBoundResource<List<Catalogue>, List<ShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<Catalogue>> {
                return Transformations.map(localDataSource.getAllShows()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Catalogue>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ShowResponse>>> =
                remoteDataSource.getAllShows()

            override fun saveCallResult(data: List<ShowResponse>) {
                val showList = DataMapper.mapResponsesShowToEntities(data)
                localDataSource.insertCatalogue(showList)
            }
        }.asLiveData()

    override fun getFavoriteMovie(): LiveData<List<Catalogue>> {
        return Transformations.map(localDataSource.getFavoriteMovie()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getFavoriteShow(): LiveData<List<Catalogue>> {
        return Transformations.map(localDataSource.getFavoriteShow()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavorite(catalogue: Catalogue, state: Boolean) {
        val mainEntity = DataMapper.mapDomainToEntity(catalogue)
        appExecutors.diskIO().execute { localDataSource.setFavorite(mainEntity, state) }
    }
}