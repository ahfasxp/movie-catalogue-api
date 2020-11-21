package com.ahfasxp.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ShowResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("original_name")
    val title: String,

    @field:SerializedName("original_language")
    val tagline: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val poster_path: String
)