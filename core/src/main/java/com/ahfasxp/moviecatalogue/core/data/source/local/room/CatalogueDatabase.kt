package com.ahfasxp.moviecatalogue.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahfasxp.moviecatalogue.core.data.source.local.entity.MainEntity

@Database(
    entities = [MainEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CatalogueDatabase : RoomDatabase() {
    abstract fun catalogueDao(): CatalogueDao
}