package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.Observer
import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.BaseActivity
import com.wesoft.mvvmachitecture.databinding.ActivityMainBinding
import com.wesoft.mvvmachitecture.extension.bindLinearLayout

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private val adapter = lazy { MainAdapter() }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setupViews() {
        viewModel.categories.observe(this, Observer { dataList ->
            adapter.value.updateDataList(dataList)
        })
        viewModel.getCategories()

        mBinding.rvCategory.bindLinearLayout(this, adapter.value)
    }

}
