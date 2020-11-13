package com.ahfasxp.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MainEntity> = DataDummy.generateDummyMovie()
}