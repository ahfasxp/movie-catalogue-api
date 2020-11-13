package com.ahfasxp.moviecatalogue.ui.tvShow

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
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.ui.detail.DetailActivity
import com.ahfasxp.moviecatalogue.ui.main.MainAdapter
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
            val showViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[ShowViewModel::class.java]
            val show = showViewModel.getTvshow()

            //Menginisialisasi RecycleView dari MainAdapter
            val showAdapter = MainAdapter()
            showAdapter.setData(show)
            showAdapter.notifyDataSetChanged()

            rv_show.layoutManager = GridLayoutManager(activity, 2)
            rv_show.setHasFixedSize(true)
            rv_show.adapter = showAdapter
            showAdapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
                override fun onItemClicked(data: MainEntity) {
                    showSelectedShow(data)
                }
            })
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    //Metode item yang dipilih
    private fun showSelectedShow(show: MainEntity) {
        Toast.makeText(activity, "Kamu memilih ${show.title}", Toast.LENGTH_SHORT).show()
        //Tidak bisa menggunakan Navigation
//        view?.findNavController()?.navigate(R.id.action_movieFragment_to_detailActivity)
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, show.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, "show")
        startActivity(intent)
    }
}