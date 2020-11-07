package com.ahfasxp.moviecatalogue.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.Main
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MovieViewModel : ViewModel() {
    val listMovie = MutableLiveData<ArrayList<Main>>()

    fun setMovie() {
        val listItems = ArrayList<Main>()
        val apiKey = "29e92e83b6a7e979bf220ee210dfd9bb"
        val url = "https://api.themoviedb.org/3/movie/popular?api_key=${apiKey}"
        val client = AsyncHttpClient()
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                try {
                    //parsing json
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val list = responseObject.getJSONArray("results")
                    for (i in 0 until list.length()) {
                        val getMovie = list.getJSONObject(i)
                        val main = Main()
                        main.id = getMovie.getInt("id")
                        main.title = getMovie.getString("title")
                        main.poster_path = getMovie.getString("poster_path")
                        listItems.add(main)
                    }
                    listMovie.postValue(listItems)
                } catch (e: Exception) {
                    Log.d("Exception", e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                Log.d("onFailure", error.message.toString())
            }
        })
    }

    fun getMovies(): LiveData<ArrayList<Main>> {
        return listMovie
    }
}