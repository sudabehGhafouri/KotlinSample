package com.mersana.kotlinsample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mersana.kotlinsample.database.dao.SearchDao
import com.mersana.kotlinsample.model.SearchModel

@Database(entities = [SearchModel::class],version = 1,exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class DataBase: RoomDatabase() {
    abstract fun searchDao() : SearchDao


    companion object {

        @Volatile
        private var INSTANCE: DataBase? = null
        fun getInstance(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "subscriber_data_database"
                    )

                        .build()
                }
                return instance
            }
        }
    }
}