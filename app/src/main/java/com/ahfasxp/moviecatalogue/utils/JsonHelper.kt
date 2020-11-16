package com.ahfasxp.moviecatalogue.utils

import android.content.Context
import com.ahfasxp.moviecatalogue.data.source.remote.response.MainResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MainResponse> {
        val list = ArrayList<MainResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val tagline = movie.getString("tagline")
                val overview = movie.getString("overview")
                val posterPath = movie.getString("poster_path")

                val movieResponse = MainResponse(id, title, tagline, overview, posterPath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadShows(): List<MainResponse> {
        val list = ArrayList<MainResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("shows")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val tagline = movie.getString("tagline")
                val overview = movie.getString("overview")
                val posterPath = movie.getString("poster_path")

                val showResponse = MainResponse(id, title, tagline, overview, posterPath)
                list.add(showResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}