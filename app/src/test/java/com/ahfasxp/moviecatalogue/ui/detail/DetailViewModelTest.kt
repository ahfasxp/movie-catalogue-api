package com.ahfasxp.moviecatalogue.ui.detail

import com.ahfasxp.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyShow = DataDummy.generateDummyTvshow()[0]
    private val movieId = dummyMovie.id
    private val showId = dummyShow.id

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
    }

    @Test
    fun getMovie() {
        detailViewModel.setSelected(dummyMovie.id)
        val movieEntity = detailViewModel.getMovie()
        //Memastikan data movie tidak null
        assertNotNull(movieEntity)
        //Memastikan data movie sesuai yang diharapkan
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.tagline, movieEntity.tagline)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.poster_path, movieEntity.poster_path)
    }

    @Test
    fun getShow() {
        detailViewModel.setSelected(dummyShow.id)
        val showEntity = detailViewModel.getShow()
        //Memastikan data show tidak null
        assertNotNull(showEntity)
        //Memastikan data show sesuai yang diharapkan
        assertEquals(dummyShow.title, showEntity.title)
        assertEquals(dummyShow.id, showEntity.id)
        assertEquals(dummyShow.tagline, showEntity.tagline)
        assertEquals(dummyShow.overview, showEntity.overview)
        assertEquals(dummyShow.poster_path, showEntity.poster_path)
    }
}