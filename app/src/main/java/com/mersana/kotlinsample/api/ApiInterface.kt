package com.mersana.kotlinsample.api

import com.mersana.kotlinsample.model.SearchResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search/repositories?sort=stargazers_count")
    fun searchRepos(@Query("q") query : String,
                    @Query("page") page : Int,
                    @Query("per_page") ItemsPerPage : Int) :
            Call<SearchResponseModel>
}