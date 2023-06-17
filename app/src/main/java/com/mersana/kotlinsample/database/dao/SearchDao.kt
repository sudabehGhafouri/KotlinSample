package com.mersana.kotlinsample.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mersana.kotlinsample.model.SearchModel

@Dao
interface SearchDao {


    @Query("select * from SearchModel")
    fun getSearch() : LiveData<List<SearchModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearch(repos : List<SearchModel>)

    @Update
    fun updateSearch(repo : SearchModel)

    @Query("delete from SearchModel")
    fun deleteSearch()

    @Delete
    fun deleteSearch(repo : SearchModel)


}