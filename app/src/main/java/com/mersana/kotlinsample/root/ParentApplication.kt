package com.mersana.kotlinsample.root


import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.mersana.kotlinsample.database.DataBaseModule

class ParentApplication : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var instance: ParentApplication
    }


    private lateinit var component: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .dataBaseModule(DataBaseModule(applicationContext))

            .build()
    }


    fun getComponent(): ApplicationComponent {
        return component
    }

}