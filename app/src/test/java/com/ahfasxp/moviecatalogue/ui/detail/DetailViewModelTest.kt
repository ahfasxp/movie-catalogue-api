package com.ahfasxp.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ahfasxp.moviecatalogue.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.utils.DataDummy
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
class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyShow = DataDummy.generateDummyTvshow()[0]
    private val movieId = dummyMovie.id
    private val showId = dummyShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var detailObserver: Observer<MainEntity>

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(catalogueRepository)
        detailViewModel.setSelected("1")
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MainEntity>()
        movie.value = dummyMovie

        `when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(movie)
        //Memanipulasi data ketika pemanggilan data movie di kelas repository.
        val movieEntity = detailViewModel.getMovie().value as MainEntity
        //Memastikan metode di kelas repository terpanggil.
        verify(catalogueRepository).getDetailMovie(movieId)
        //Melakukan pengecekan data movie apakah null atau tidak.
        assertNotNull(movieEntity)
        //Membandingkan data movie sudah sesuai dengan yang diharapkan atau tidak.
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.tagline, movieEntity.tagline)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.poster_path, movieEntity.poster_path)

        detailViewModel.getMovie().observeForever(detailObserver)
        verify(detailObserver).onChanged(dummyMovie)
    }

    @Test
    fun getShow() {
        val show = MutableLiveData<MainEntity>()
        show.value = dummyShow

        `when`(catalogueRepository.getDetailShow(showId)).thenReturn(show)
        //Memanipulasi data ketika pemanggilan data show di kelas repository.
        val showEntity = detailViewModel.getShow().value as MainEntity
        //Memastikan metode di kelas repository terpanggil.
        verify(catalogueRepository).getDetailShow(showId)
        //Melakukan pengecekan data show apakah null atau tidak.
        assertNotNull(showEntity)
        //Membandingkan data show sudah sesuai dengan yang diharapkan atau tidak.
        assertEquals(dummyShow.id, showEntity.id)
        assertEquals(dummyShow.title, showEntity.title)
        assertEquals(dummyShow.tagline, showEntity.tagline)
        assertEquals(dummyShow.overview, showEntity.overview)
        assertEquals(dummyShow.poster_path, showEntity.poster_path)

        detailViewModel.getShow().observeForever(detailObserver)
        verify(detailObserver).onChanged(dummyShow)
    }
}