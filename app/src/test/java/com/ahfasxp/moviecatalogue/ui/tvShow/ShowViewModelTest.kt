package com.ahfasxp.moviecatalogue.ui.tvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.core.data.CatalogueRepository
import com.ahfasxp.moviecatalogue.core.utils.DataDummy
import com.ahfasxp.moviecatalogue.tvShow.ShowViewModel
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
class ShowViewModelTest {
    private lateinit var showViewModel: ShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<MainEntity>>

    @Before
    fun setUp() {
        showViewModel = ShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvshow() {
        val dummyShows = DataDummy.generateDummyTvshow()
        val shows = MutableLiveData<List<MainEntity>>()
        shows.value = dummyShows

        `when`(catalogueRepository.getAllShows()).thenReturn(shows)
        //Memanipulasi data ketika pemanggilan data show di kelas repository.
        val showEntities = showViewModel.getTvshow().value
        //Memastikan metode di kelas repository terpanggil.
        verify<CatalogueRepository>(catalogueRepository).getAllShows()
        //Melakukan pengecekan data show apakah null atau tidak.
        assertNotNull(showEntities)
        //Melakukan pengecekan jumlah data show apakah sudah sesuai atau belum.
        assertEquals(10, showEntities?.size)

        showViewModel.getTvshow().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}