package com.wesoft.mvvmachitecture.api

import com.wesoft.mvvmachitecture.model.BaseResponse
import com.wesoft.mvvmachitecture.model.CategoryBean
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by james.li on 2018/8/21.
 */

interface APIService {

    @GET("xiandu/categories")
    fun getToday(): Flowable<BaseResponse<List<CategoryBean>>>
}