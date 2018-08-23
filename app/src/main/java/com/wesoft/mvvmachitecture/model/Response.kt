package com.wesoft.mvvmachitecture.model

import android.util.Log
import com.google.gson.annotations.SerializedName
import io.reactivex.Flowable

/**
 * Created by james on 2018/8/22.
 */

open class BaseResponse {
    @SerializedName("error") var code: Boolean = true
}

fun BaseResponse.filterData(): Flowable<BaseResponse> {
    Log.d("test", "code= $code")
    return if (!code) {
        Flowable.just(this)
    }else {
        Flowable.error(Throwable("error"))
    }
}
data class Category(
        @SerializedName("results") var dataList: List<CategoryBean>
): BaseResponse()

data class CategoryBean(
        @SerializedName("_id") var id: String,
        @SerializedName("en_name") var enName: String,
        @SerializedName("name") var name: String,
        @SerializedName("rank") var rank: Int
)