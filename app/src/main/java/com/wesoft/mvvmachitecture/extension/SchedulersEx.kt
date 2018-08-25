package com.wesoft.mvvmachitecture.extension

import android.arch.lifecycle.MediatorLiveData
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
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

fun <T> Single<T>.updateLoading(loading: MediatorLiveData<Boolean>): Single<T> {
    return  this.
            doOnSubscribe { loading.value = true }
            .doFinally { loading.value = false }
}

fun <T> Observable<T>.updateLoading(loading: MediatorLiveData<Boolean>): Observable<T> {
    return  this.
            doOnSubscribe { loading.value = true }
            .doFinally { loading.value = false }
}

fun <T> Flowable<T>.updateLoading(loading: MediatorLiveData<Boolean>): Flowable<T> {
    return  this.
            doOnSubscribe { loading.value = true }
            .doFinally { loading.value = false }
}

fun Disposable.disposedBag(dispose: CompositeDisposable) {
    dispose.add(this)
}