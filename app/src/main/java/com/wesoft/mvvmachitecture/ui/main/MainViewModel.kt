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
                .subscribe(
                        {
                            data ->
                            Log.d("test", "viewModel get data= " + data.size)
                            if (categories.value != data) categories.value = data
                        },
                        {
                            error ->
                            Log.d("test", "error= ${error.message}")
                        }
                )
                .disposedBag(dispose)
    }

}