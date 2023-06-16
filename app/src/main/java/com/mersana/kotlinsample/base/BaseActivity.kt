package com.mersana.kotlinsample.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider


abstract class BaseActivity<T : BaseViewModel, E : ViewDataBinding> : AppCompatActivity(),
    LifecycleOwner {


    lateinit var viewModel: T

    lateinit var binding: E

    abstract fun getResourceLayoutId(): Int

    abstract fun getClassViewModel(): Class<T>

    abstract fun getFactory(): ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * dataBinding
         */
        binding = DataBindingUtil.setContentView(this, getResourceLayoutId())

        /**
         * viewModel
         */
        viewModel = ViewModelProvider(this, getFactory()).get(getClassViewModel())
        lifecycle.addObserver(viewModel)


    }
}