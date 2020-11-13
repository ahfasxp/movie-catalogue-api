package com.ahfasxp.moviecatalogue.ui.tvShow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ShowViewModelTest {
    private lateinit var showViewModel: ShowViewModel

    @Before
    fun setUp() {
        showViewModel = ShowViewModel()
    }

    @Test
    fun getTvshow() {
        val showEntities = showViewModel.getTvshow()
        //Memastikan data show tidak null
        assertNotNull(showEntities)
        //Memastikan jumlah show sesuai yang diharapkan yaitu 10
        assertEquals(10, showEntities.size)
    }
}