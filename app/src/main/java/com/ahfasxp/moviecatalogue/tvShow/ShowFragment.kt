package com.ahfasxp.moviecatalogue.tvShow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.detail.DetailActivity
import com.ahfasxp.moviecatalogue.core.ui.MainAdapter
import com.ahfasxp.moviecatalogue.core.ui.ViewModelFactory
import com.ahfasxp.moviecatalogue.core.vo.Status
import kotlinx.android.synthetic.main.fragment_show.*
import kotlinx.android.synthetic.main.fragment_show.progressBar

/**
 * A simple [Fragment] subclass.
 * Use the [ShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            //ViewModel
            val factory = ViewModelFactory.getInstance(requireActivity())
            val showViewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]

            //Menginisialisasi RecycleView dari MainAdapter
            val showAdapter = MainAdapter()
            progressBar.visibility = View.VISIBLE
            showViewModel.getTvshow.observe(this, Observer { shows ->
                if (shows != null) {
                    when (shows.status) {
                        Status.LOADING -> progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progressBar.visibility = View.GONE
                            showAdapter.setData(shows.data)
                            showAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(rv_show) {
                layoutManager = GridLayoutManager(activity, 2)
                setHasFixedSize(true)
                adapter = showAdapter
            }
            showAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
        }
    }
}