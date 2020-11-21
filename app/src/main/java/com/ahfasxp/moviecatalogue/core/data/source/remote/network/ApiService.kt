package com.ahfasxp.moviecatalogue.core.data.source.remote.network

import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ListMovieResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ListShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovie(@Query("api_key") apiKey: String): Call<ListMovieResponse>

    @GET("tv/popular")
    fun getShow(@Query("api_key") apiKey: String): Call<ListShowResponse>
}