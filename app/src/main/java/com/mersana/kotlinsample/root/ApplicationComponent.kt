package com.mersana.kotlinsample.root

import com.mersana.kotlinsample.database.DataBaseModule
import com.mersana.kotlinsample.viewModel.MainViewModel
import dagger.Component
@Component(
    modules = arrayOf(
        ApplicationModule::class,
        DataBaseModule::class
    ),
)

        interface ApplicationComponent  {

    // inject callService to mainViewModel
        fun inject(target : MainViewModel)

}