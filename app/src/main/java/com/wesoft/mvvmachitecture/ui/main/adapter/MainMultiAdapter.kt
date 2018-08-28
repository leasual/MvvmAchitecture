package com.wesoft.mvvmachitecture.ui.main.adapter

import android.databinding.ViewDataBinding
import com.wesoft.mvvmachitecture.base.adapter.BaseAdapterItem
import com.wesoft.mvvmachitecture.base.adapter.BaseMultiTypeRecyclerAdapter
import com.wesoft.mvvmachitecture.databinding.ListitemMultiContentBinding
import com.wesoft.mvvmachitecture.databinding.ListitemMultiTitleBinding
import com.wesoft.mvvmachitecture.ui.main.MainAdapterViewModel

/**
 * Created by james on 2018/8/24.
 */
class MainMultiAdapter : BaseMultiTypeRecyclerAdapter<BaseAdapterItem, MainAdapterViewModel>() {

    override fun bindItem(binding: ViewDataBinding, model: BaseAdapterItem, position: Int, viewModel: MainAdapterViewModel) {
        when (model) {
            is TitleDataItem -> {
                val dataBinding = binding as ListitemMultiTitleBinding
                dataBinding.tvTitle.text = model.category.name
                //dataBinding.tvContent.text = model.category.enName
                binding.root.setBackgroundColor(context.resources.getColor(android.R.color.holo_green_light))
            }
            is ContentDataItem -> {
                val dataBinding = binding as ListitemMultiContentBinding
                dataBinding.tvTitle.text = model.category.name
                dataBinding.tvContent.text = model.category.rank.toString()
                binding.root.setBackgroundColor(context.resources.getColor(android.R.color.holo_blue_light))
            }
        }
    }
}