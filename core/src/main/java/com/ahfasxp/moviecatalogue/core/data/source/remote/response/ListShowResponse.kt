package com.ahfasxp.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListShowResponse(
    @field:SerializedName("results")
    val results: List<ShowResponse>
)