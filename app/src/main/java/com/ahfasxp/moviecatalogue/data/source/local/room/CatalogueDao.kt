package com.ahfasxp.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahfasxp.moviecatalogue.data.source.local.entity.MainEntity

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM mainentities WHERE type = 'movie'")
    fun getMovies(): LiveData<List<MainEntity>>

    @Query("SELECT * FROM mainentities WHERE type = 'show'")
    fun getShows(): LiveData<List<MainEntity>>

    @Query("SELECT * FROM mainentities WHERE id = :id AND type = 'movie'")
    fun getDetailMovie(id: String): LiveData<MainEntity>

    @Query("SELECT * FROM mainentities WHERE id = :id AND type = 'show'")
    fun getDetailShow(id: String): LiveData<MainEntity>

    @Query("SELECT * FROM mainentities where isFavorite = 1 AND type = 'movie'")
    fun getFavoriteMovie(): LiveData<List<MainEntity>>

    @Query("SELECT * FROM mainentities where isFavorite = 1 AND type = 'show'")
    fun getFavoriteShow(): LiveData<List<MainEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCatalogue(catalogue: List<MainEntity>)

    @Update
    fun updateCatalogue(catalogue: MainEntity)
}