package com.ahfasxp.moviecatalogue.core.data.source.remote.network

import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovie(@Query("api_key") apiKey: String): Call<ListResponse>
}