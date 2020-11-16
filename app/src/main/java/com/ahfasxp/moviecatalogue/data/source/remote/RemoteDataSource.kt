package com.ahfasxp.moviecatalogue.data.source.remote

import android.os.Handler
import com.ahfasxp.moviecatalogue.data.source.remote.response.MainResponse
import com.ahfasxp.moviecatalogue.utils.EspressoIdlingResource
import com.ahfasxp.moviecatalogue.utils.JsonHelper

@Suppress("DEPRECATION")
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

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllMoviesReceived(jsonHelper.loadMovies())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getAllShows(callback: LoadShowsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllShowsReceived(jsonHelper.loadShows())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MainResponse>)
    }

    interface LoadShowsCallback {
        fun onAllShowsReceived(showResponses: List<MainResponse>)
    }
}