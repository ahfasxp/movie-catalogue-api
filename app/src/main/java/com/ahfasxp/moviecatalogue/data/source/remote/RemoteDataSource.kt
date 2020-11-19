package com.ahfasxp.moviecatalogue.data.source.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahfasxp.moviecatalogue.data.source.remote.response.MainResponse
import com.ahfasxp.moviecatalogue.utils.EspressoIdlingResource
import com.ahfasxp.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MainResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MainResponse>>>()
        handler.postDelayed(
            {
                resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
        return resultMovie
    }

    fun getAllShows(): LiveData<ApiResponse<List<MainResponse>>> {
        EspressoIdlingResource.increment()
        val resultShow = MutableLiveData<ApiResponse<List<MainResponse>>>()
        handler.postDelayed(
            {
                resultShow.value = ApiResponse.success(jsonHelper.loadShows())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return resultShow
    }
}