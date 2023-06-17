package com.mersana.kotlinsample.viewModel


import androidx.lifecycle.*
import com.mersana.kotlinsample.api.CallServices
import com.mersana.kotlinsample.base.BaseViewModel

import com.mersana.kotlinsample.database.accessDatabase.SearchAccess
import com.mersana.kotlinsample.repository.DataRepository
import com.mersana.kotlinsample.root.ParentApplication
import com.mersana.kotlinsample.utils.SingleLiveEvent

import javax.inject.Inject


class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var callServices: CallServices

    @Inject
    lateinit var searchAccess: SearchAccess

    private var dataRepository: DataRepository

    init {

        ParentApplication.instance.getComponent().inject(this)
        dataRepository = DataRepository(searchAccess = searchAccess, callServices = callServices)

    }
    private val searchQuery = MutableLiveData<String>()

    fun searchQuery(query: String) {
        searchQuery.postValue(query)
        onDataRequest.postValue(Any())
    }

    private val searchResult = Transformations.map(searchQuery) {
        dataRepository.searchRepoByQuery(it)
    }

    val data = Transformations.switchMap(searchResult) {
        it.data
    }

    val status = Transformations.switchMap(searchResult) {
        it!!.network
    }

    val onDataRequest: SingleLiveEvent<Any> = SingleLiveEvent()


    data class SearchResult(val data: LiveData<List<String>>, val network: LiveData<String>)


    class Factory() : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            return MainViewModel() as T
        }
    }
}