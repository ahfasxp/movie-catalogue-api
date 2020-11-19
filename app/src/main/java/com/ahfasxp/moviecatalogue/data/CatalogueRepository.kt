package com.ahfasxp.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahfasxp.moviecatalogue.data.source.local.LocalDataSource
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.source.remote.ApiResponse
import com.ahfasxp.moviecatalogue.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.data.source.remote.response.MainResponse
import com.ahfasxp.moviecatalogue.utils.AppExecutors
import com.ahfasxp.moviecatalogue.vo.Resource

class CatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogueDataSource {

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

    override fun getAllMovies(): LiveData<Resource<List<MainEntity>>> {
        return object : NetworkBoundResource<List<MainEntity>, List<MainResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MainEntity>> =
                localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MainEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MainResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(movieResponses: List<MainResponse>) {
                val movieList = ArrayList<MainEntity>()
                for (response in movieResponses) {
                    val movie = MainEntity(
                        response.id,
                        response.title,
                        response.tagline,
                        response.overview,
                        response.poster_path,
                        false,
                        "movie"
                    )
                    movieList.add(movie)
                }

                localDataSource.insertCatalogue(movieList)
            }
        }.asLiveData()
    }

    override fun getAllShows(): LiveData<Resource<List<MainEntity>>> {
        return object : NetworkBoundResource<List<MainEntity>, List<MainResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MainEntity>> =
                localDataSource.getAllShows()

            override fun shouldFetch(data: List<MainEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MainResponse>>> =
                remoteDataSource.getAllShows()

            public override fun saveCallResult(showResponses: List<MainResponse>) {
                val showList = ArrayList<MainEntity>()
                for (response in showResponses) {
                    val show = MainEntity(
                        response.id,
                        response.title,
                        response.tagline,
                        response.overview,
                        response.poster_path,
                        false,
                        "show"
                    )
                    showList.add(show)
                }

                localDataSource.insertCatalogue(showList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(id: String): LiveData<Resource<MainEntity>> {
        return object : NetworkBoundResource<MainEntity, List<MainResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MainEntity> =
                localDataSource.getDetailMovie(id)

            override fun shouldFetch(data: MainEntity?): Boolean =
                data == null

            public override fun createCall(): LiveData<ApiResponse<List<MainResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(movieResponses: List<MainResponse>) {
                val movieList = ArrayList<MainEntity>()
                lateinit var movie: MainEntity
                for (response in movieResponses) {
                    if (response.id == id) {
                        movie = MainEntity(
                            response.id,
                            response.title,
                            response.tagline,
                            response.overview,
                            response.poster_path,
                            false,
                            "movie"
                        )
                    }
                }
                localDataSource.insertCatalogue(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailShow(id: String): LiveData<Resource<MainEntity>> {
        return object : NetworkBoundResource<MainEntity, List<MainResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MainEntity> =
                localDataSource.getDetailShow(id)

            override fun shouldFetch(data: MainEntity?): Boolean =
                data == null

            public override fun createCall(): LiveData<ApiResponse<List<MainResponse>>> =
                remoteDataSource.getAllShows()

            override fun saveCallResult(showResponses: List<MainResponse>) {
                val showList = ArrayList<MainEntity>()
                lateinit var show: MainEntity
                for (response in showResponses) {
                    if (response.id == id) {
                        show = MainEntity(
                            response.id,
                            response.title,
                            response.tagline,
                            response.overview,
                            response.poster_path,
                            false,
                            "show"
                        )
                    }
                }
                localDataSource.insertCatalogue(showList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<List<MainEntity>> =
        localDataSource.getFavoriteMovie()

    override fun getFavoriteShow(): LiveData<List<MainEntity>> =
        localDataSource.getFavoriteShow()

    override fun setFavorite(main: MainEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavorite(main, state) }
    }
}