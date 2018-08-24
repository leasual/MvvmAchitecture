package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.MediatorLiveData
import android.util.Log
import com.wesoft.mvvmachitecture.base.BaseViewModel
import com.wesoft.mvvmachitecture.model.CategoryBean
import com.wesoft.mvvmachitecture.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by james.li on 2018/8/21.
 */

@Singleton
class MainViewModel @Inject constructor() : BaseViewModel<MainRepository>() {

    var categories = MediatorLiveData<List<CategoryBean>>()
    var isLoading = MediatorLiveData<Boolean>()
    var errorMessage = MediatorLiveData<String>()


    fun getCategories() {
        dispose.add(repository.getCategories()
                .doOnSubscribe {
                    isLoading.value = true
                }
                .doFinally {
                    isLoading.value = false
                }
                .subscribe(
                        {
                            data ->
                            if (categories.value != data) categories.value = data
                        },
                        {
                            error ->
                            Log.d("test", "error= ${error.message}")
                            errorMessage.value = error.message
                        }
                )
        )
    }

}