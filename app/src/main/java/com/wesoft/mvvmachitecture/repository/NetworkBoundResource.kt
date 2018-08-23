package com.wesoft.mvvmachitecture.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.util.Log
import com.wesoft.mvvmachitecture.model.BaseResponse
import com.wesoft.mvvmachitecture.model.filterData
import com.wesoft.mvvmachitecture.util.ioMain
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by james on 2018/8/22.
 */
abstract class NetworkBoundResource<ResultType, RequestType: BaseResponse> constructor(private val disposable: CompositeDisposable) {

    private val result = MediatorLiveData<RequestType>()

    init {
        result.value = null
        fetchFromNetwork()
    }

    protected abstract fun shouldFetch(data: ResultType): Boolean

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun cache(data: ResultType)

    protected abstract fun callApi(): Flowable<RequestType>

    private fun setValue(newValue: RequestType) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork() {
        Log.d("test", "fetchFromNetwork")
        disposable.add(
                callApi()
                        .flatMap { it.filterData() }
                        .ioMain()
                        .subscribe(
                                {
                                    data ->
                                    val response = data
                                    setValue(response as RequestType)
                                },
                                {
                                    error ->
                                    Log.d("test", "error= ${error.message}")
                                }
                        )
        )
        Log.d("test", "size= " + disposable.size())
    }

    fun asLiveData() = result as LiveData<ResultType>
}