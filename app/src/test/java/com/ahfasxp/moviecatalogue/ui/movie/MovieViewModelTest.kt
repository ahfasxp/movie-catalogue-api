package com.ahfasxp.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.utils.DataDummy
import com.ahfasxp.moviecatalogue.movie.MovieViewModel
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<MainEntity>>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<List<MainEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllMovies()).thenReturn(movies)
        //Memanipulasi data ketika pemanggilan data movie di kelas repository.
        val movieEntities = movieViewModel.getMovies().value
        //Memastikan metode di kelas repository terpanggil.
        verify<CatalogueRepository>(catalogueRepository).getAllMovies()
        //Melakukan pengecekan data movie apakah null atau tidak.
        assertNotNull(movieEntities)
        //Melakukan pengecekan jumlah data movie apakah sudah sesuai atau belum.
        assertEquals(10, movieEntities?.size)

        movieViewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}