package com.wesoft.mvvmachitecture.ui.main

import android.util.Log
import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.adapter.BaseRecyclerAdapter
import com.wesoft.mvvmachitecture.databinding.ListitemSimpleBinding
import com.wesoft.mvvmachitecture.model.CategoryBean

/**
 * Created by james on 2018/8/24.
 */

class MainAdapter : BaseRecyclerAdapter<ListitemSimpleBinding, CategoryBean, MainAdapterViewModel>() {


    override fun bindItem(binding: ListitemSimpleBinding, model: CategoryBean, position: Int, viewModel: MainAdapterViewModel) {
        binding.tvTitle.text = model.name
        binding.tvContent.text = model.rank.toString()
        if (viewModel.isEmail()) {
            Log.d("test", "isEmail")
        }
    }

    override fun getLayoutId(): Int = R.layout.listitem_simple

}