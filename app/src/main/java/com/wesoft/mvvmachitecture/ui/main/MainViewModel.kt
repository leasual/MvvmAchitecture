package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.MediatorLiveData
import com.wesoft.mvvmachitecture.base.BaseViewModel
import com.wesoft.mvvmachitecture.model.CategoryBean
import com.wesoft.mvvmachitecture.repository.MainRepository
import com.wesoft.mvvmachitecture.extension.disposedBag
import com.wesoft.mvvmachitecture.extension.updateLoading
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
                    if (categories.value != it) categories.value = it
                }
                .disposedBag(dispose)
    }

}