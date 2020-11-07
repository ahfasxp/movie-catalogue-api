package com.ahfasxp.moviecatalogue.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.data.Main
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_items.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val mData = ArrayList<Main>()

    fun setData(items: ArrayList<Main>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainAdapter.MainViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return MainViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(main: Main) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${main.poster_path}")
                    .apply(RequestOptions().override(350, 550))
                    .into(img_poster)
                tv_title.text = main.title

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(main) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Main)
    }
}