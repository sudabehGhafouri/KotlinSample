package com.mersana.kotlinsample.api

import android.content.Context
import com.mersana.kotlinsample.model.SearchModel
import com.mersana.kotlinsample.model.SearchResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallServices(context:Context) {

    var apiService =  ApiClient.getClient(context) !!.create(ApiInterface::class.java)

    fun searchRepos(

        query: String,
        page: Int,
        itemsPerPage: Int,
        onError: (error: String) -> Unit,
        onSuccess: (repos: List<SearchModel>) -> Unit
    ) {
        val apiQuery = query + IN_QUALIFIER

        apiService.searchRepos(apiQuery, page, itemsPerPage).enqueue(object :
            Callback<SearchResponseModel> {

            override fun onFailure(call: Call<SearchResponseModel>, t: Throwable) {
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<SearchResponseModel>,
                response: Response<SearchResponseModel>
            ) {
                if (response.isSuccessful) {
                    response.body().let {
                        if (it != null)
                            onSuccess(it.items)
                        else
                            onError("empty response")
                    }
                } else {
                    onError("error connecting server")
                }
            }
        })

    }
}
private const val IN_QUALIFIER = "in:name,description"

