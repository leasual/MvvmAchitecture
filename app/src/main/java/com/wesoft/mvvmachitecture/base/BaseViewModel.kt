package com.wesoft.mvvmachitecture.base

import android.arch.lifecycle.ViewModel
import android.util.Log
import javax.inject.Inject

/**
 * Created by james on 2018/8/21.
 */
abstract class BaseViewModel<R: BaseRepository> : ViewModel() {

    @Inject
    lateinit var repository: R

    override fun onCleared() {
        super.onCleared()
        if (!repository.dispose.isDisposed) {
            repository.dispose.dispose()
            repository.dispose.clear()
        }
    }
}