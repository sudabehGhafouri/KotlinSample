package com.mersana.kotlinsample.database.accessDatabase

import androidx.lifecycle.LiveData
import com.mersana.kotlinsample.database.DataBase
import com.mersana.kotlinsample.model.SearchModel
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class SearchAccess (
    private val database: DataBase,

    ) {

        fun insertSearch(repos: List<SearchModel>) {


                Completable.fromAction { database.searchDao().insertSearch(repos) }
                    .subscribeOn(
                        Schedulers.io()
                    )
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(object :
                        CompletableObserver {
                        override fun onSubscribe(d: Disposable) {}
                        override fun onComplete() {
                        }

                        override fun onError(e: Throwable) {
                        }
                    })
        }



        fun getSearch(): LiveData<List<SearchModel>> = database.searchDao().getSearch()
    }
