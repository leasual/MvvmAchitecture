package com.wesoft.mvvmachitecture.model

import android.util.Log
import com.google.gson.annotations.SerializedName
import io.reactivex.Flowable

/**
 * Created by james on 2018/8/22.
 */

data class BaseResponse<T> (
    @SerializedName("error") var code: Boolean,
    @SerializedName("results") var data: T
)

fun <T> BaseResponse<T>.filterData(): Flowable<BaseResponse<T>> {
    Log.d("test", "code= $code")
    return if (!code) {
        Flowable.just(this)
    }else {
        Flowable.error(Throwable("error"))
    }
}

data class CategoryBean(
        @SerializedName("_id") var id: String,
        @SerializedName("en_name") var enName: String,
        @SerializedName("name") var name: String,
        @SerializedName("rank") var rank: Int
)