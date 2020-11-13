package com.ahfasxp.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getMovie(): MainEntity {
        lateinit var movie: MainEntity
        val movieEntities = DataDummy.generateDummyMovie()
        for (mainEntity in movieEntities) {
            if (mainEntity.id == id) {
                movie = mainEntity
            }
        }
        return movie
    }

    fun getShow(): MainEntity {
        lateinit var show: MainEntity
        val showEntities = DataDummy.generateDummyTvshow()
        for (mainEntity in showEntities) {
            if (mainEntity.id == id) {
                show = mainEntity
            }
        }
        return show
    }
}