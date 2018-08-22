package com.wesoft.mvvmachitecture.base

import com.wesoft.mvvmachitecture.api.APIService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by james on 2018/8/21.
 */

abstract class BaseRepository {

    @Inject
    lateinit var apiService: APIService

    val dispose: CompositeDisposable = CompositeDisposable()

}