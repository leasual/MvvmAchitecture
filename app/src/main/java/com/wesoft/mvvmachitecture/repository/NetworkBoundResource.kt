package com.wesoft.mvvmachitecture.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by james on 2018/8/22.
 */
abstract class NetworkBoundResource<ResultType, RequestType> constructor(private val disposable: CompositeDisposable) {

    private val result = MediatorLiveData<ResultType>()

    init {
        result.value = null
        val dbSource = loadFromDB()
        result.addSource(dbSource) { data ->
            if (shouldFetch(data!!)) {
                fetchFromNetwork(dbSource)
            }
        }
    }

    protected abstract fun shouldFetch(data: ResultType): Boolean

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun cache(data: RequestType)

    protected abstract fun callApi(): LiveData<RequestType>

    private fun setValue(newValue: ResultType) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = callApi()
        result.addSource(dbSource) { newData ->
            setValue(newData!!)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response) {

            }
        }
    }

    fun asLiveData() = result as LiveData<ResultType>
}