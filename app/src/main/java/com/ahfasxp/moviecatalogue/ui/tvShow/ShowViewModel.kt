package com.ahfasxp.moviecatalogue.ui.tvShow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.Main
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class ShowViewModel : ViewModel() {
    val listShow = MutableLiveData<ArrayList<Main>>()

    fun setShow() {
        val listItems = ArrayList<Main>()
        val apiKey = "29e92e83b6a7e979bf220ee210dfd9bb"
        val url = "https://api.themoviedb.org/3/tv/popular?api_key=${apiKey}"
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
                        val getShow = list.getJSONObject(i)
                        val main = Main()
                        main.id = getShow.getInt("id")
                        main.title = getShow.getString("name")
                        main.poster_path = getShow.getString("poster_path")
                        listItems.add(main)
                    }
                    listShow.postValue(listItems)
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

    fun getShow(): LiveData<ArrayList<Main>> {
        return listShow
    }
}