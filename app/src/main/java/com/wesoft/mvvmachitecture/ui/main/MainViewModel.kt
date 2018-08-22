package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.LiveData
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

    var categories: LiveData<List<CategoryBean>>? = null
        get() = repository.getCategories()

    fun getRepo(): String = repository.getResult()
}