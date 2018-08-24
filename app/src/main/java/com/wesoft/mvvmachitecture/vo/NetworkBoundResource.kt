package com.wesoft.mvvmachitecture.vo

import android.util.Log
import com.wesoft.mvvmachitecture.model.BaseResponse
import com.wesoft.mvvmachitecture.model.filterData
import com.wesoft.mvvmachitecture.util.ioMain
import io.reactivex.Flowable

/**
 * Created by james on 2018/8/22.
 */
//https://android.jlelse.eu/networkboundresource-with-rxjava-and-kotlin-sealed-classes-1574bc516f82

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result: Flowable<ResultType>

    init {
        //cache
        val diskFlowable = Flowable.defer {
            loadFromDB()
                    ?.ioMain()
        }
        //network
        val networkFlowable = Flowable.defer {
            callApi()
                    .flatMap { (it as BaseResponse<*>).filterData() }
                    .ioMain()
                    .doOnNext {
                       cache(it.data as ResultType)
                    }
                    .onErrorReturn {
                        Log.d("test", "error return= ${it.printStackTrace()}")
                        throw it
                    }
        }.flatMap { loadFromDB() }

        //whether should fetch from network
        @Suppress("LeakingThis")
        result = networkFlowable//shouldFetch(null).let { networkFlowable } ?: diskFlowable

    }

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDB(): Flowable<ResultType>?

    protected abstract fun cache(data: ResultType)

    protected abstract fun callApi(): Flowable<RequestType>

    fun asFlowable() = result
}