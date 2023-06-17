package com.mersana.kotlinsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mersana.kotlinsample.databinding.RecyclerviewDataItemBinding
import com.mersana.kotlinsample.model.SearchModel

class DataRecyclerViewAdapter(val searchList: List<SearchModel>) :
    RecyclerView.Adapter<DataRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewDataItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun getItemCount(): Int = searchList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(searchList[position])
    }

    class Holder(val binding: RecyclerviewDataItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: SearchModel) {
            binding.item = repo
        }
    }
}