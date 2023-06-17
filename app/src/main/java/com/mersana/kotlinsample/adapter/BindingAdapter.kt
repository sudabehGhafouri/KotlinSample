package com.mersana.kotlinsample.adapter

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("showOrGone")
        fun ProgressBar.setVisibilityProgress(showing: Boolean) {
            this.visibility = if (showing) View.VISIBLE else View.INVISIBLE
        }


        @JvmStatic
        @BindingAdapter("rvAdapter")
        fun RecyclerView.setAdapter(adapter: DataRecyclerViewAdapter?) {
            if (adapter != null)
                this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        }

    }
}
