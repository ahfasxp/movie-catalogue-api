package com.ahfasxp.moviecatalogue.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.network.ApiService
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.ListResponse
import com.ahfasxp.moviecatalogue.core.data.source.remote.response.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
//    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MainResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<MainResponse>>>()

        //get data from remote api
        val client = apiService.getMovie("29e92e83b6a7e979bf220ee210dfd9bb")

        client.enqueue(object : Callback<ListResponse> {
            override fun onResponse(
                call: Call<ListResponse>,
                response: Response<ListResponse>
            ) {
                val dataArray = response.body()?.results
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })
        return resultData
    }

    fun getAllShows(): LiveData<ApiResponse<List<MainResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<MainResponse>>>()

        val client = apiService.getMovie("29e92e83b6a7e979bf220ee210dfd9bb")

        client.enqueue(object : Callback<ListResponse> {
            override fun onResponse(
                call: Call<ListResponse>,
                response: Response<ListResponse>
            ) {
                val dataArray = response.body()?.results
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })
        return resultData
    }
}