package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.ViewModel
import com.wesoft.mvvmachitecture.base.BaseViewModel
import com.wesoft.mvvmachitecture.repository.MainRepository
import javax.inject.Inject

/**
 * Created by james.li on 2018/8/21.
 */
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : BaseViewModel() {

    fun getTestString(): String = "Hello world"
}