package com.mersana.kotlinsample.root

import android.app.Application
import android.content.Context
import com.mersana.kotlinsample.api.CallServices
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val applicationContext: Context) {

    private var application: Application? = null


    @Provides
    @Singleton
    fun provideContext(): Context? {
        return application?.applicationContext
    }

    @Provides
    open fun providerCallService(): CallServices {
        return CallServices(applicationContext)

    }
}