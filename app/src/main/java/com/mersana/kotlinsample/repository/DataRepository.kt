package com.mersana.kotlinsample.repository

import androidx.lifecycle.MutableLiveData
import com.mersana.kotlinsample.api.CallServices
import com.mersana.kotlinsample.database.repository.SearchRepository

import com.mersana.kotlinsample.model.SearchResultModel

class DataRepository constructor(
    private val cache : SearchRepository,

    private val callServices : CallServices
) {
    val network = MutableLiveData<Boolean>()


    fun searchRepoByQuery(query : String) : SearchResultModel {
        network.postValue(true)

        val data = cache.loadRepos()

       callServices.searchRepos(query = query,page = 1,itemsPerPage = 21,onError = {
            network.postValue(false)
        }, onSuccess = {
            //insert db
            cache.insertRepo(it)
            //data.postValue(it)
            network.postValue(false)
        })
        return SearchResultModel(data,network)
    }
}