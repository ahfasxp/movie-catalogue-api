package com.ahfasxp.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //ViewModel
        val factory = ViewModelFactory.getInstance(this)
        val detailViewModel: DetailViewModel =
            ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_ID)
        val type = intent.getStringExtra(EXTRA_TYPE)
        when (type) {
            getString(R.string.movie) -> {
                if (id != null) {
                    detailViewModel.setSelected(id)
                    progressBar.visibility = View.VISIBLE
                    detailViewModel.getMovie()
                        .observe(this, Observer { movie -> populateDetail(movie) })
                }
            }
            getString(R.string.show) -> {
                if (id != null) {
                    detailViewModel.setSelected(id)
                    progressBar.visibility = View.VISIBLE
                    detailViewModel.getShow()
                        .observe(this, Observer { show -> populateDetail(show) })
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
    }
}