package com.ahfasxp.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
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
                showLoading(true)
                if (id != null) {
                    detailViewModel.setSelected(id)
                    pupulateDetail(detailViewModel.getMovie())
                }
            }
            getString(R.string.show) -> {
                showLoading(true)
                if (id != null) {
                    detailViewModel.setSelected(id)
                    pupulateDetail(detailViewModel.getShow())
                }
            }
        }
    }

    private fun pupulateDetail(main: MainEntity) {
        Glide.with(this@DetailActivity)
            .load(main.poster_path)
            .into(img_poster)
        tv_title.text = main.title
        tv_tagline.text = main.tagline
        tv_overview.text = main.overview
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}