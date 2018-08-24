package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.Observer
import android.util.Log
import android.widget.Toast
import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.BaseActivity
import com.wesoft.mvvmachitecture.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setupViews() {
        viewModel.categories.observe(this, Observer { dataList ->
            Log.d("test", "dataList size= ${dataList?.size}")
            mBinding.tvTitle.text = dataList?.get(0)?.name
        })
        viewModel.isLoading.observe(this, Observer { isLoading ->
            Toast.makeText(this, "loading= $isLoading", Toast.LENGTH_SHORT).show()
        })
        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, "message= $message", Toast.LENGTH_SHORT).show()
        })
        viewModel.getCategories()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "destroy")
    }
}
