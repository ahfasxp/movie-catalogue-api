package com.ahfasxp.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ahfasxp.moviecatalogue.R
import com.bumptech.glide.Glide
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_detail.*
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        when (type) {
            "movie" -> {
                showLoading(true)
                setDetailMovie(id)
            }
            "show" -> {
                showLoading(true)
                setDetailShow(id)
            }
        }
    }

    //Metode detail movie
    private fun setDetailMovie(id: Int) {
        val apiKey = "29e92e83b6a7e979bf220ee210dfd9bb"
        val url = "https://api.themoviedb.org/3/movie/${id}?api_key=${apiKey}"
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
                    Glide.with(this@DetailActivity)
                        .load("https://image.tmdb.org/t/p/w500${responseObject.getString("poster_path")}")
                        .into(img_poster)
                    tv_title.text = responseObject.getString("title")
                    tv_tagline.text = responseObject.getString("tagline")
                    tv_overview.text = responseObject.getString("overview")
                    showLoading(false)
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

    //Metode detail tvShow
    private fun setDetailShow(id: Int) {
        val apiKey = "29e92e83b6a7e979bf220ee210dfd9bb"
        val url = "https://api.themoviedb.org/3/tv/${id}?api_key=${apiKey}"
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
                    Glide.with(this@DetailActivity)
                        .load("https://image.tmdb.org/t/p/w500${responseObject.getString("poster_path")}")
                        .into(img_poster)
                    tv_title.text = responseObject.getString("original_name")
                    tv_tagline.text = responseObject.getString("status")
                    tv_overview.text = responseObject.getString("overview")
                    showLoading(false)
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

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}