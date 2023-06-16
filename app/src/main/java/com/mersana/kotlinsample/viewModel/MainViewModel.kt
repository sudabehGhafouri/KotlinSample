package com.mersana.kotlinsample.viewModel


import androidx.lifecycle.*
import com.mersana.kotlinsample.api.CallServices
import com.mersana.kotlinsample.base.BaseViewModel

import com.mersana.kotlinsample.database.repository.SearchRepository
import com.mersana.kotlinsample.repository.DataRepository
import com.mersana.kotlinsample.root.ParentApplication
import com.mersana.kotlinsample.tools.SingleLiveEvent

import javax.inject.Inject


class MainViewModel : BaseViewModel() {
@Inject
 lateinit var callServices:CallServices
 @Inject
 lateinit var searchRepository: SearchRepository
    lateinit var repoSearch : DataRepository

    init {
        ParentApplication.instance.getComponent().inject(this)

     repoSearch = DataRepository(cache = searchRepository,callServices = callServices)

    }
    private val searchQuery = MutableLiveData<String>()

    val repo = Transformations.map(searchQuery) {
        repoSearch.searchRepoByQuery(it)
    }

    val data = Transformations.switchMap(repo){
        it.data
    }

    val status = Transformations.switchMap(repo){
        it!!.network
    }

    val onDataRequest : SingleLiveEvent<Any> = SingleLiveEvent()

    fun searchQuery(query : String){
        searchQuery.postValue(query)
        onDataRequest.postValue(Any())
    }

    data class SearchResult(val data : LiveData<List<String>>, val network : LiveData<String>)



    class Factory() : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            return MainViewModel() as T
        }
    }
}