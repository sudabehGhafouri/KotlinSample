package com.mersana.kotlinsample.database.repository

import androidx.lifecycle.LiveData
import com.mersana.kotlinsample.database.DataBase
import com.mersana.kotlinsample.model.SearchModel
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class SearchRepository (
    private val database: DataBase,

    ) {

        fun insertRepo(repos: List<SearchModel>) {


                Completable.fromAction { database.searchDao().insertRepos(repos) }
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



        fun loadRepos(): LiveData<List<SearchModel>> = database.searchDao().loadRepos()
    }
