package com.wesoft.mvvmachitecture.ui.main

import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by james.li on 2018/8/21.
 */
class MainViewModel @Inject constructor() : ViewModel() {

    fun getTestString(): String = "Hello world"
}