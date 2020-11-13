package com.ahfasxp.moviecatalogue.ui.tvShow

import androidx.lifecycle.ViewModel
import com.ahfasxp.moviecatalogue.data.MainEntity
import com.ahfasxp.moviecatalogue.utils.DataDummy

class ShowViewModel : ViewModel() {
    fun getTvshow(): List<MainEntity> = DataDummy.generateDummyTvshow()
}