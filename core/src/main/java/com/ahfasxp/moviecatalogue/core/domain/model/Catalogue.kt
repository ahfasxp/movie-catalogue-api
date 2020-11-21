package com.ahfasxp.moviecatalogue.core.domain.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Catalogue(
    var id: String,
    var title: String,
    var tagline: String,
    var overview: String,
    var poster_path: String,
    var isFavorite: Boolean,
    var type: String? = null
) : Parcelable