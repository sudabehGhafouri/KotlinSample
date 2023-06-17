package com.mersana.kotlinsample.repository

import androidx.lifecycle.MutableLiveData
import com.mersana.kotlinsample.api.CallServices
import com.mersana.kotlinsample.database.accessDatabase.SearchAccess

import com.mersana.kotlinsample.model.SearchResultModel

class DataRepository constructor(

    private val searchAccess: SearchAccess,
    private val callServices: CallServices
) {

    private val network = MutableLiveData<Boolean>()
    fun searchRepoByQuery(query: String): SearchResultModel {
        network.postValue(true)

        val data = searchAccess.getSearch()

        callServices.searchRepos(query = query, page = 1, itemsPerPage = 21, onError = {
            network.postValue(false)
        }, onSuccess = {
            //insert database
            searchAccess.insertSearch(it)
            //data.postValue(it)
            network.postValue(false)
        })
        return SearchResultModel(data, network)
    }
}