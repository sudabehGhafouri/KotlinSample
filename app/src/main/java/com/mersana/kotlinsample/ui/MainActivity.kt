package com.mersana.kotlinsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mersana.kotlinsample.R
import com.mersana.kotlinsample.adapter.DataRecyclerViewAdapter
import com.mersana.kotlinsample.base.BaseActivity
import com.mersana.kotlinsample.databinding.ActivityMainBinding
import com.mersana.kotlinsample.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * viewModel
         */
        viewModel.searchQuery("android")
        viewModel.data.observe(this, Observer {
            binding.adapter = DataRecyclerViewAdapter(it)
        })
        viewModel.status.observe(this, Observer {
            binding.loading = it!!
        })
        viewModel.onDataRequest.observe(this, Observer {
            //to do something
        })

    }

    override fun getResourceLayoutId(): Int =R.layout.activity_main

    override fun getClassViewModel(): Class<MainViewModel> =MainViewModel::class.java

    override fun getFactory(): ViewModelProvider.Factory =MainViewModel.Factory()
}