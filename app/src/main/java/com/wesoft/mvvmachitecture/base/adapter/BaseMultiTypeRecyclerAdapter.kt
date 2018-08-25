package com.wesoft.mvvmachitecture.base.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by james on 2018/8/24.
 */

abstract class BaseMultiTypeRecyclerAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
            RecyclerViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), viewType, parent, false))

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        getViewModel(position)?.let {
            holder.bindItem(position, it)
        }
    }

    override fun getItemViewType(position: Int): Int = getLayoutIdForPosition(position)

    fun getLayoutIdForPosition(position: Int): Int {
        val item = getObjectForPosition(position)
        return layoutTypes()[item] ?: throw RuntimeException("Could't find layout for $item")
    }

    abstract fun getViewModel(position: Int): Any?

    abstract fun getObjectForPosition(position: Int): Any

    abstract fun layoutTypes(): Map<Class<*>, Int>
}