package com.ahfasxp.moviecatalogue.favorite.favoriteTvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.core.ui.MainAdapter
import com.ahfasxp.moviecatalogue.core.ui.ViewModelFactory
import com.ahfasxp.moviecatalogue.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_favorite_show.*
import kotlinx.android.synthetic.main.fragment_movie.progressBar

class FavoriteShowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val favoriteShowViewModel =
                ViewModelProvider(this, factory)[FavoriteShowViewModel::class.java]

            //Menginisialisasi RecycleView dari MainAdapter
            val favoriteShowAdapter = MainAdapter()
            progressBar.visibility = View.VISIBLE
            favoriteShowViewModel.getFavoriteShow.observe(this, Observer { shows ->
                progressBar.visibility = View.GONE
                favoriteShowAdapter.setData(shows)
                favoriteShowAdapter.notifyDataSetChanged()
            })

            with(rv_favorite_show) {
                layoutManager = GridLayoutManager(activity, 2)
                setHasFixedSize(true)
                adapter = favoriteShowAdapter
            }
            favoriteShowAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
        }
    }
}