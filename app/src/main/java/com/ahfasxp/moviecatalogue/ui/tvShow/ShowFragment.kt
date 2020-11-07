package com.ahfasxp.moviecatalogue.ui.tvShow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.ui.main.MainAdapter
import kotlinx.android.synthetic.main.fragment_show.*
import kotlinx.android.synthetic.main.fragment_show.progressBar

/**
 * A simple [Fragment] subclass.
 * Use the [ShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowFragment : Fragment() {
    private lateinit var adapter: MainAdapter
    private lateinit var showViewModel: ShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Menginisialisasi RecycleView dari MainAdapter
        adapter = MainAdapter()
        adapter.notifyDataSetChanged()
        rv_show.layoutManager = GridLayoutManager(activity, 2)
        rv_show.adapter = adapter

        //Menginisialisasi ShowViewModel
        showViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ShowViewModel::class.java)
        showLoading(true)
        showViewModel.setShow()

        showViewModel.getShow().observe(this, Observer { main ->
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
}