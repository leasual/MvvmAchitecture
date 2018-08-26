package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.Observer
import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.BaseActivity
import com.wesoft.mvvmachitecture.base.adapter.BaseAdapterItem
import com.wesoft.mvvmachitecture.databinding.ActivityMainBinding
import com.wesoft.mvvmachitecture.extension.bindLinearLayout

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    //private val adapter = lazy { MainMultiAdapter() }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setupViews() {
        //viewModel.getCategories()
        //mBinding.rvCategory.bindLinearLayout(this, adapter.value)

        supportFragmentManager.beginTransaction()
                .add(R.id.fl_container, MainFragment.newInstance())
                .commit()
    }

    override fun observeData() {
//        viewModel.categories.observe(this, Observer { dataList ->
//            val resultDataList = arrayListOf<BaseAdapterItem>()
//            dataList?.map {
//                resultDataList.add(TitleDataItem(it))
//                resultDataList.add(ContentDataItem(it))
//            }
//            adapter.value.updateDataList(resultDataList)
//        })
    }

}
