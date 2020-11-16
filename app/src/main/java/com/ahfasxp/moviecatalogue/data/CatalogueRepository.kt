package com.ahfasxp.moviecatalogue.data

import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.source.remote.RemoteDataSource

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteData)
            }
    }

    override fun getAllMovies(): ArrayList<MainEntity> {
        val moviesResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MainEntity>()
        for (response in moviesResponses) {
            val movie = MainEntity(
                response.id,
                response.title,
                response.tagline,
                response.overview,
                response.poster_path
            )
            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllShows(): ArrayList<MainEntity> {
        val showsResponses = remoteDataSource.getAllShows()
        val showList = ArrayList<MainEntity>()
        for (response in showsResponses) {
            val show = MainEntity(
                response.id,
                response.title,
                response.tagline,
                response.overview,
                response.poster_path
            )
            showList.add(show)
        }
        return showList
    }

    override fun getDetailMovie(id: String): MainEntity {
        val movieResponses = remoteDataSource.getAllMovies()
        lateinit var movie: MainEntity
        for (response in movieResponses) {
            if (response.id == id) {
                movie = MainEntity(
                    response.id,
                    response.title,
                    response.tagline,
                    response.overview,
                    response.poster_path
                )
            }
        }
        return movie
    }

    override fun getDetailShow(id: String): MainEntity {
        val showResponses = remoteDataSource.getAllShows()
        lateinit var show: MainEntity
        for (response in showResponses) {
            if (response.id == id) {
                show = MainEntity(
                    response.id,
                    response.title,
                    response.tagline,
                    response.overview,
                    response.poster_path
                )
            }
        }
        return show
    }
}