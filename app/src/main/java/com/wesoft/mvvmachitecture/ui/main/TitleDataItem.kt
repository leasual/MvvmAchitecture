package com.wesoft.mvvmachitecture.ui.main

import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.adapter.BaseAdapterItem
import com.wesoft.mvvmachitecture.model.CategoryBean

/**
 * Created by james on 2018/8/24.
 */
class TitleDataItem(val category: CategoryBean) : BaseAdapterItem(){

    override fun getLayoutId(): Int = R.layout.listitem_multi_title
}