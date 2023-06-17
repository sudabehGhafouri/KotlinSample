package com.mersana.kotlinsample.database

import android.content.Context
import com.mersana.kotlinsample.database.accessDatabase.SearchAccess

import dagger.Module
import dagger.Provides

@Module
class DataBaseModule (val applicationContext: Context){



    @Provides
    fun provideRepoDataBase(): DataBase{
        return  DataBase.getInstance(applicationContext);
    }

    @Provides
    fun provideSearchRepository() : SearchAccess{
        return SearchAccess(provideRepoDataBase())
    }
}