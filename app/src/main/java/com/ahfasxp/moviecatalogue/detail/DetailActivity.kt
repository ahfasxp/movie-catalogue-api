package com.ahfasxp.moviecatalogue.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private val detailViewModel: DetailViewModel by viewModel()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detail = intent.getParcelableExtra<Catalogue>(EXTRA_DATA)
        progressBar.visibility = View.VISIBLE
        populateDetail(detail)
    }

    private fun populateDetail(main: Catalogue?) {
        main?.let {
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500${main.poster_path}")
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