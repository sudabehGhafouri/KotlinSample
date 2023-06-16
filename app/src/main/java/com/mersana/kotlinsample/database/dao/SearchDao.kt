package com.mersana.kotlinsample.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mersana.kotlinsample.model.SearchModel

@Dao
interface SearchDao {

    @Query("select * from SearchModel ORDER BY id DESC limit 1")
    fun lastRepo() : LiveData<SearchModel>


    @Query("select * from SearchModel")
    fun loadRepos() : LiveData<List<SearchModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepos(repos : List<SearchModel>)

    @Update
    fun updateRepo(repo : SearchModel)

    @Query("delete from SearchModel")
    fun deleteRepos()

    @Delete
    fun deleteRepo(repo : SearchModel)


}