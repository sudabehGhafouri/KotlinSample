package com.mersana.kotlinsample.database


import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.util.*


@TypeConverters
class DataConverter {

    @TypeConverter
    fun convertToString(obj : JsonObject) : String {
        return Gson().fromJson(obj, String::class.java)
    }

    @TypeConverter
    fun convertToJsonObject(value : String) : JsonObject {
        return Gson().toJson(value) as JsonObject
    }

    @TypeConverter
    fun convertDateToString(date : Date) : String {
        return date.toString()
    }
}