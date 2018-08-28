package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.Observer
import com.wesoft.mvvmachitecture.App
import com.wesoft.mvvmachitecture.R
import com.wesoft.mvvmachitecture.base.BaseFragment
import com.wesoft.mvvmachitecture.base.adapter.BaseAdapterItem
import com.wesoft.mvvmachitecture.databinding.FragmentMainBinding
import com.wesoft.mvvmachitecture.extension.bindLinearLayout
import com.wesoft.mvvmachitecture.ui.main.adapter.ContentDataItem
import com.wesoft.mvvmachitecture.ui.main.adapter.MainMultiAdapter
import com.wesoft.mvvmachitecture.ui.main.adapter.TitleDataItem

/**
 * Created by james on 2018/8/26.
 */
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {

    private val adapter = lazy { MainMultiAdapter() }

    override fun getLayoutId(): Int = R.layout.fragment_main

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun setupViews() {
        viewModel.getCategories()
        mBinding.rvCategory.bindLinearLayout(App.instance.applicationContext, adapter.value)
    }

    override fun observeData() {
        viewModel.categories.observe(this, Observer { dataList ->
            val resultDataList = arrayListOf<BaseAdapterItem>()
            dataList?.map {
                resultDataList.add(TitleDataItem(it))
                resultDataList.add(ContentDataItem(it))
            }
            adapter.value.updateDataList(resultDataList)
        })
    }
}