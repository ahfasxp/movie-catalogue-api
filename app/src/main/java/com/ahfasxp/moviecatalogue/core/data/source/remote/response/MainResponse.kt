package com.ahfasxp.moviecatalogue.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MainResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("original_title")
    val title: String,

    @field:SerializedName("original_language")
    val tagline: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val poster_path: String
)