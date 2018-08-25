package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.Observer
import android.util.Log
import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.BaseActivity
import com.wesoft.mvvmachitecture.databinding.ActivityMainBinding
import com.wesoft.mvvmachitecture.extension.putString

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setupViews() {
        viewModel.categories.observe(this, Observer { dataList ->
            Log.d("test", "dataList size= ${dataList?.size}")
            mBinding.tvTitle.text = dataList?.get(0)?.name
            mPreferences.defaultPreferences.putString("name", dataList?.get(0)?.name)
            Log.d("test", "name= ${mPreferences.defaultPreferences.getString("name", "")}")
        })
        viewModel.getCategories()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "destroy")
    }
}
