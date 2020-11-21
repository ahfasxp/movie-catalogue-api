package com.ahfasxp.moviecatalogue.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahfasxp.moviecatalogue.R
import com.ahfasxp.moviecatalogue.core.domain.model.Catalogue
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_items.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var listData = ArrayList<Catalogue>()
    var onItemClick: ((Catalogue) -> Unit)? = null

    fun setData(items: List<Catalogue>?) {
        if (items == null) return
        listData.clear()
        listData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return MainViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(main: Catalogue) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(main.poster_path)
                    .apply(
                        RequestOptions().override(350, 550).placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(img_poster)
                tv_title.text = main.title

                itemView.setOnClickListener {
                    onItemClick?.invoke(listData[adapterPosition])
                }
            }
        }

    }
}
