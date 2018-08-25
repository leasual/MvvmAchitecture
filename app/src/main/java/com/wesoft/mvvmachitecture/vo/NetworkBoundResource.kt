package com.wesoft.mvvmachitecture.vo

import android.util.Log
import com.wesoft.mvvmachitecture.App
import com.wesoft.mvvmachitecture.api.APIException
import com.wesoft.mvvmachitecture.extension.isNetworkAvailable
import com.wesoft.mvvmachitecture.extension.toast
import com.wesoft.mvvmachitecture.model.BaseResponse
import com.wesoft.mvvmachitecture.model.filterData
import com.wesoft.mvvmachitecture.extension.ioMain
import io.reactivex.Flowable
import retrofit2.HttpException

/**
 * Created by james on 2018/8/22.
 */

abstract class NetworkBoundResource<ResultType, RequestType>(val app: App) {

    private val result: Flowable<ResultType>

    init {
        //cache
        val diskFlowable = Flowable.defer {
            loadFromDB()
                    ?.ioMain()
        }
        //network
        @Suppress("UNCHECKED_CAST")
        val networkFlowable = Flowable.defer {
            callApi()
                    .flatMap { (it as BaseResponse<*>).filterData() }
                    .ioMain()
                    .doOnNext {
                        cache(it.data as ResultType)
                    }
                    .onErrorResumeNext { throwable: Throwable ->
                        when (throwable) {
                            is HttpException -> {
                                if (throwable.response().code() == 404) {
                                    app.applicationContext.toast("服务器地址不存在")
                                } else {
                                    app.applicationContext.toast("网络不给力，请重试")
                                }
                            }
                            is APIException -> {
                                app.applicationContext.toast(throwable.info)
                            }
                            else -> {
                                app.applicationContext.toast("数据异常，请重试")
                            }
                        }
                        Log.d("test", "error return= ${throwable.printStackTrace()}")
                        Flowable.empty()
                    }
        }.flatMap { Flowable.just(it.data as ResultType) }

        //whether should fetch from network
        val networkState = app.applicationContext.isNetworkAvailable()
        @Suppress("LeakingThis")
        when (networkState) {
            true -> result = shouldFetch(null).let { networkFlowable } ?: diskFlowable
            else -> {
                app.applicationContext.toast("网络未连接，请检查网络再重试")
                result = Flowable.empty()
            }
        }
    }

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDB(): Flowable<ResultType>?

    protected abstract fun cache(data: ResultType)

    protected abstract fun callApi(): Flowable<RequestType>

    fun asFlowable() = result
}