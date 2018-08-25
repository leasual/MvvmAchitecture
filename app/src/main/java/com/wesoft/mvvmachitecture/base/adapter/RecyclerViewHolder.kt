package com.wesoft.mvvmachitecture.base.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by james on 2018/8/24.
 */
open class RecyclerViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(position: Int, viewModel: Any) {}
}