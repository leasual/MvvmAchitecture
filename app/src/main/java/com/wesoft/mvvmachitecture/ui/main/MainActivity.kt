package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.Observer
import android.util.Log
import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.BaseActivity
import com.wesoft.mvvmachitecture.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setupViews() {
        mBinding.tvTitle.text = viewModel.getRepo()
        viewModel.categories?.observe(this, Observer { dataList ->
           Log.d("test", "dataList size= ${dataList?.size}")
       })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "destroy")
    }
}
