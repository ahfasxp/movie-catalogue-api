package com.ahfasxp.moviecatalogue.core.data.source.remote

import android.util.Log
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiService
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAllMovies(): Flow<ApiResponse<List<MovieResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getMovie("29e92e83b6a7e979bf220ee210dfd9bb")
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllShows(): Flow<ApiResponse<List<ShowResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getShow("29e92e83b6a7e979bf220ee210dfd9bb")
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}