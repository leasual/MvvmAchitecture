package com.wesoft.mvvmachitecture.ui.main

import com.wesoft.mvvmachitecture.base.BaseViewModel
import com.wesoft.mvvmachitecture.repository.MainRepository
import javax.inject.Inject

/**
 * Created by james.li on 2018/8/21.
 */
class MainViewModel @Inject constructor() : BaseViewModel<MainRepository>() {

    fun getTestString(): String = "Hello world"

    fun getRepo(): String = repository.getResult()
}