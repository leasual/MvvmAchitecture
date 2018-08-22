package com.wesoft.mvvmachitecture.api

import android.arch.lifecycle.LiveData
import com.wesoft.mvvmachitecture.model.CategoryBean
import retrofit2.http.GET

/**
 * Created by james.li on 2018/8/21.
 */

interface APIService {

    @GET("today")
    fun getToday(): LiveData<List<CategoryBean>>
}