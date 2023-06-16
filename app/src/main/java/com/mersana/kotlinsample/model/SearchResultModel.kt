package com.mersana.kotlinsample.model

import androidx.lifecycle.LiveData



data class SearchResultModel(
    val data : LiveData<List<SearchModel>>?,
    val network : LiveData<Boolean>?
)