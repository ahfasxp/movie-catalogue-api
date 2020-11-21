package com.ahfasxp.moviecatalogue.favorite.favoriteMovie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.core.ui.MainAdapter
import com.ahfasxp.moviecatalogue.detail.DetailActivity
import com.ahfasxp.moviecatalogue.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import kotlinx.android.synthetic.main.fragment_movie.progressBar
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteMovieFragment : Fragment() {
    //ViewModel
    private val favoriteMovieViewModel: FavoriteMovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            //Menginisialisasi RecycleView dari MainAdapter
            val favoriteMovieAdapter = MainAdapter()
            progressBar.visibility = View.VISIBLE
            favoriteMovieViewModel.getFavoriteMovie.observe(this, Observer { movies ->
                progressBar.visibility = View.GONE
                favoriteMovieAdapter.setData(movies)
                favoriteMovieAdapter.notifyDataSetChanged()
            })

            with(rv_favorite_movie) {
                layoutManager = GridLayoutManager(activity, 2)
                setHasFixedSize(true)
                adapter = favoriteMovieAdapter
            }
            favoriteMovieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
        }
    }
}