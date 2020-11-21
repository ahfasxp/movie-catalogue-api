package com.ahfasxp.moviecatalogue.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM mainentities WHERE type = 'movie'")
    fun getMovies(): Flow<List<MainEntity>>

    @Query("SELECT * FROM mainentities WHERE type = 'show'")
    fun getShows(): Flow<List<MainEntity>>
//
//    @Query("SELECT * FROM mainentities WHERE id = :id AND type = 'movie'")
//    fun getDetailMovie(id: String): LiveData<MainEntity>
//
//    @Query("SELECT * FROM mainentities WHERE id = :id AND type = 'show'")
//    fun getDetailShow(id: String): LiveData<MainEntity>

    @Query("SELECT * FROM mainentities where isFavorite = 1 AND type = 'movie'")
    fun getFavoriteMovie(): Flow<List<MainEntity>>

    @Query("SELECT * FROM mainentities where isFavorite = 1 AND type = 'show'")
    fun getFavoriteShow(): Flow<List<MainEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatalogue(catalogue: List<MainEntity>)

    @Update
    fun updateCatalogue(catalogue: MainEntity)
}