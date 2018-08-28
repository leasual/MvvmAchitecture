package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.MediatorLiveData
import android.util.Log
import com.wesoft.mvvmachitecture.base.BaseViewModel
import com.wesoft.mvvmachitecture.extension.disposedBag
import com.wesoft.mvvmachitecture.extension.updateLoading
import com.wesoft.mvvmachitecture.model.CategoryBean
import com.wesoft.mvvmachitecture.repository.MainRepository
import javax.inject.Inject

/**
 * Created by james.li on 2018/8/21.
 */

class MainViewModel @Inject constructor() : BaseViewModel<MainRepository>() {

    var categories = MediatorLiveData<MutableList<CategoryBean>>()

    fun getCategories() {
        repository
                .getCategories()
                .updateLoading(isLoading)
                .subscribe {
                    Log.d("test", "viewModel get data= " + it.size)
                    if (categories.value != it) categories.value = it
                }
                .disposedBag(dispose)
    }

}