package com.mersana.kotlinsample.model

import com.google.gson.annotations.SerializedName

/**
 * Data class to hold repo responses from searchRepo API calls.
 */
data class SearchResponseModel(
    @SerializedName("total_count") val total: Int = 0,

    @SerializedName("items") val items: List<SearchModel> = emptyList(),

    val nextPage: Int? = null
)
