package com.ahfasxp.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainResponse(
    val id: String,
    val title: String,
    val tagline: String,
    val overview: String,
    val poster_path: String
) : Parcelable