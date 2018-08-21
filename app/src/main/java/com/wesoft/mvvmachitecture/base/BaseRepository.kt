package com.wesoft.mvvmachitecture.base

import com.wesoft.mvvmachitecture.api.APIService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by james on 2018/8/21.
 */
@Singleton
abstract class BaseRepository @Inject constructor() {
    @Inject
    lateinit var apiService: APIService
}