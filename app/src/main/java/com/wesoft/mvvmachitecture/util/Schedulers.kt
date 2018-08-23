package com.wesoft.mvvmachitecture.util

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by james.li on 2018/8/23.
 */

fun <T> Single<T>.ioMain(): Single<T> {
    return  this.
            subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.ioMain(): Observable<T> {
    return  this.
            subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.ioMain(): Flowable<T> {
    return  this.
            subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}