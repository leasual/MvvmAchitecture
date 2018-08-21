package com.wesoft.mvvmachitecture.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by james on 2018/8/21.
 */
open class BaseViewModel : ViewModel() {

    val dispose: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        if (!dispose.isDisposed) {
            dispose.dispose()
            dispose.clear()
        }
    }
}