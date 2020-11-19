package com.ahfasxp.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.viewmodel.ViewModelFactory
import com.ahfasxp.moviecatalogue.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.progressBar
import kotlinx.android.synthetic.main.fragment_movie.*

class DetailActivity : AppCompatActivity() {
    private lateinit var detailViewModel: DetailViewModel

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //ViewModel
        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_ID)
        val type = intent.getStringExtra(EXTRA_TYPE)
        when (type) {
            getString(R.string.movie) -> {
                if (id != null) {
                    detailViewModel.setSelected(id)
                    progressBar.visibility = View.VISIBLE
                    detailViewModel.getMovie()
                        .observe(this, Observer { movie ->
                            if (movie != null) {
                                when (movie.status) {
                                    Status.LOADING -> progressBar.visibility = View.VISIBLE
                                    Status.SUCCESS -> {
                                        progressBar.visibility = View.GONE
                                        movie.data?.let { populateDetail(it) }
                                    }
                                    Status.ERROR -> {
                                        progressBar.visibility = View.GONE
                                        Toast.makeText(
                                            applicationContext,
                                            "Terjadi kesalahan",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                        })
                }
            }
            getString(R.string.show) -> {
                if (id != null) {
                    detailViewModel.setSelected(id)
                    progressBar.visibility = View.VISIBLE
                    detailViewModel.getShow()
                        .observe(this, Observer { show ->
                            if (show != null) {
                                when (show.status) {
                                    Status.LOADING -> progressBar.visibility = View.VISIBLE
                                    Status.SUCCESS -> {
                                        progressBar.visibility = View.GONE
                                        show.data?.let { populateDetail(it) }
                                    }
                                    Status.ERROR -> {
                                        progressBar.visibility = View.GONE
                                        Toast.makeText(
                                            applicationContext,
                                            "Terjadi kesalahan",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                        })
                }
            }
        }
    }

    private fun populateDetail(main: MainEntity) {
        Glide.with(this@DetailActivity)
            .load(main.poster_path)
            .apply(
                RequestOptions().placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_poster)
        tv_title.text = main.title
        tv_tagline.text = main.tagline
        tv_overview.text = main.overview
        progressBar.visibility = View.GONE

        var statusFavorite = main.isFavorite
        setFavorite(statusFavorite)
        fab_favorite.setOnClickListener {
            statusFavorite = !statusFavorite
            detailViewModel.setFavorite(main, statusFavorite)
            setFavorite(statusFavorite)
        }
    }

    private fun setFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            fab_favorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_black
                )
            )
        } else {
            fab_favorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border_black
                )
            )
        }
    }
}