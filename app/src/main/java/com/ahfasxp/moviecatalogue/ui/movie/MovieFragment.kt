package com.ahfasxp.moviecatalogue.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.data.Main
import com.ahfasxp.moviecatalogue.ui.detail.DetailActivity
import com.ahfasxp.moviecatalogue.ui.main.MainAdapter
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Menginisialisasi RecycleView dari MainAdapter
        val adapter = MainAdapter()
        adapter.notifyDataSetChanged()
        rv_movie.layoutManager = GridLayoutManager(activity, 2)
        rv_movie.adapter = adapter
        adapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Main) {
                showSelectedMovie(data)
            }
        })

        //Menginisialisasi MovieViewModel
        movieViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MovieViewModel::class.java)
        showLoading(true)
        movieViewModel.setMovie()

        movieViewModel.getMovies().observe(this, Observer { main ->
            if (main != null) {
                adapter.setData(main)
                showLoading(false)
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

    //Metode item yang dipilih
    private fun showSelectedMovie(movie: Main) {
        Toast.makeText(activity, "Kamu memilih ${movie.title}", Toast.LENGTH_SHORT).show()
        //Tidak bisa menggunakan Navigation
//        view?.findNavController()?.navigate(R.id.action_movieFragment_to_detailActivity)
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, movie.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, "movie")
        startActivity(intent)
    }
}