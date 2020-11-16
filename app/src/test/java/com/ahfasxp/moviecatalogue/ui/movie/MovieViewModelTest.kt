package com.ahfasxp.moviecatalogue.ui.movie

import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.utils.DataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        `when`<ArrayList<MainEntity>>(catalogueRepository.getAllMovies()).thenReturn(
            DataDummy.generateDummyMovie()
        )
        //Memanipulasi data ketika pemanggilan data movie di kelas repository.
        val movieEntities = movieViewModel.getMovies()
        //Memastikan metode di kelas repository terpanggil.
        verify<CatalogueRepository>(catalogueRepository).getAllMovies()
        //Melakukan pengecekan data movie apakah null atau tidak.
        assertNotNull(movieEntities)
        //Melakukan pengecekan jumlah data movie apakah sudah sesuai atau belum.
        assertEquals(10, movieEntities.size)
    }
}