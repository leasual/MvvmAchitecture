package com.wesoft.mvvmachitecture.vo

import android.arch.lifecycle.LiveData

/**
 * Created by james.li on 2018/8/24.
 */
class AbsentLiveData<T : Any?> private constructor() : LiveData<T>() {
    init {
        // use post instead of set since this can be created on any thread
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}