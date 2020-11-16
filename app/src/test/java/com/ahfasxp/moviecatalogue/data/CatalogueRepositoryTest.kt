package com.ahfasxp.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ahfasxp.moviecatalogue.data.source.remote.RemoteDataSource
import com.ahfasxp.moviecatalogue.utils.DataDummy
import com.ahfasxp.moviecatalogue.utils.LiveDataTestUtil
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import com.nhaarman.mockitokotlin2.any
import org.mockito.Mockito.*

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val showResponses = DataDummy.generateRemoteDummyTvshow()
    private val id = "1"

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowsCallback)
                .onAllShowsReceived(showResponses)
            null
        }.`when`(remote).getAllShows(any())
        val showEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllShows())
        verify(remote).getAllShows(any())
        assertNotNull(showEntities)
        assertEquals(showResponses.size.toLong(), showEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())

        val movieEntities =
            LiveDataTestUtil.getValue(catalogueRepository.getDetailMovie(id))
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
        assertEquals(movieResponses[0].title, movieEntities.title)
    }

    @Test
    fun getDetailShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowsCallback)
                .onAllShowsReceived(showResponses)
            null
        }.`when`(remote).getAllShows(any())

        val showEntities =
            LiveDataTestUtil.getValue(catalogueRepository.getDetailShow(id))
        verify(remote).getAllShows(any())
        assertNotNull(showEntities)
        assertNotNull(showEntities.title)
        assertEquals(showResponses[0].title, showEntities.title)
    }
}