package com.wesoft.mvvmachitecture.base.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wesoft.mvvmachitecture.base.BaseAdapterViewModel
import com.wesoft.mvvmachitecture.vo.ViewModelTypeResolver

/**
 * Created by james on 2018/8/24.
 */

abstract class BaseMultiTypeRecyclerAdapter<T: BaseAdapterItem, in VM : BaseAdapterViewModel> : RecyclerView.Adapter<RecyclerViewHolder>() {
    lateinit var context: Context
    private var onItemClick: ((position: Int, model: T) -> Unit)? = null

    @Suppress("UNCHECKED_CAST")
    private val viewModel: VM = (ViewModelTypeResolver.findViewModelType<BaseAdapterViewModel>(this.javaClass))?.newInstance() as VM

    private var dataList: MutableList<T> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        context = parent.context
        return RecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        @Suppress("UNCHECKED_CAST")
        bindItem(holder.binding, dataList[position], position, viewModel)
        onItemClick?.invoke(position, dataList[position])
    }

    override fun getItemViewType(position: Int): Int = dataList[position].getLayoutId()

    override fun getItemCount(): Int = dataList.size

    abstract fun bindItem(binding: ViewDataBinding, model: T, position: Int, viewModel: VM)

    fun updateDataList(dataList: MutableList<T>?) {
        if (dataList !== null) {
            this.dataList = dataList
        } else {
            this.dataList.clear()
        }
        this.notifyDataSetChanged()
    }

    fun addItem(item: T) {
        dataList.add(item)
    }

    fun removeItem(item: T) {
        dataList.remove(item)
    }

    fun clearItem() {
        dataList.clear()
    }

    interface Item {
        @LayoutRes
        fun getLayoutId(): Int


    }

    fun setOnItemClickListener(func: (position: Int, model: T) -> Unit) {
        this.onItemClick = func
    }
}

