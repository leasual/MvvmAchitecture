package com.wesoft.mvvmachitecture.base

import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by james on 2018/8/21.
 */
abstract class BaseViewModel<R: BaseRepository> : ViewModel() {
    val dispose: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var repository: R

    override fun onCleared() {
        super.onCleared()
        if (!dispose.isDisposed) {
            dispose.dispose()
            dispose.clear()
            Log.d("test", "clear dispose")
        }
    }
}