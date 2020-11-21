package com.ahfasxp.moviecatalogue.core.data.source.remote.network

import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ListMovieResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ListShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getMovie(@Query("api_key") apiKey: String): ListMovieResponse

    @GET("tv/popular")
    suspend fun getShow(@Query("api_key") apiKey: String): ListShowResponse
}