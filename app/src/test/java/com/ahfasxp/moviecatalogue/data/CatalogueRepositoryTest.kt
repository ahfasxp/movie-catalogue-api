package com.ahfasxp.moviecatalogue.data

import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity
import com.ahfasxp.moviecatalogue.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.data.source.remote.response.MainResponse
import com.ahfasxp.moviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.stubbing.OngoingStubbing

class CatalogueRepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val showResponses = DataDummy.generateRemoteDummyTvshow()
    private val id = "1"

    @Test
    fun getAllMovies() {
        `when`<List<MainResponse>>(remote.getAllMovies()).thenReturn(movieResponses)
        val movieEntities = catalogueRepository.getAllMovies()
        verify<RemoteDataSource>(remote).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllShows() {
        `when`<List<MainResponse>>(remote.getAllShows()).thenReturn(showResponses)
        val showEntities = catalogueRepository.getAllShows()
        verify<RemoteDataSource>(remote).getAllShows()
        assertNotNull(showEntities)
        assertEquals(showResponses.size.toLong(), showEntities.size.toLong())
    }

    @Test
    fun getAllDetailMovie() {
        `when`<List<MainResponse>>(remote.getAllMovies()).thenReturn(movieResponses)
        val resultMovie = catalogueRepository.getDetailMovie(id)
        verify<RemoteDataSource>(remote).getAllMovies()
        assertNotNull(resultMovie)
        assertEquals(movieResponses[0].title, resultMovie.title)
    }

    @Test
    fun getAllDetailShow() {
        `when`<List<MainResponse>>(remote.getAllShows()).thenReturn(showResponses)
        val resultShow = catalogueRepository.getDetailShow(id)
        verify<RemoteDataSource>(remote).getAllShows()
        assertNotNull(resultShow)
        assertEquals(showResponses[0].title, resultShow.title)
    }
}