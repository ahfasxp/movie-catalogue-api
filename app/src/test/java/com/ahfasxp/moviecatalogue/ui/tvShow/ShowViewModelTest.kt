package com.ahfasxp.moviecatalogue.ui.tvShow

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
class ShowViewModelTest {
    private lateinit var showViewModel: ShowViewModel

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Before
    fun setUp() {
        showViewModel = ShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvshow() {
        `when`<ArrayList<MainEntity>>(catalogueRepository.getAllShows()).thenReturn(
            DataDummy.generateDummyTvshow()
        )
        //Memanipulasi data ketika pemanggilan data show di kelas repository.
        val showEntities = showViewModel.getTvshow()
        //Memastikan metode di kelas repository terpanggil.
        verify<CatalogueRepository>(catalogueRepository).getAllShows()
        //Melakukan pengecekan data show apakah null atau tidak.
        assertNotNull(showEntities)
        //Melakukan pengecekan jumlah data show apakah sudah sesuai atau belum.
        assertEquals(10, showEntities.size)
    }
}