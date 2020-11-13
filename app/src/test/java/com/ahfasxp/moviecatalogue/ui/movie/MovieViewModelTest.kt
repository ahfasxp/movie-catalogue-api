package com.ahfasxp.moviecatalogue.ui.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = movieViewModel.getMovies()
        //Memastikan data movie tidak null
        assertNotNull(movieEntities)
        //Memastikan jumlah movie sesuai yang diharapkan yaitu 10
        assertEquals(10, movieEntities.size)
    }
}