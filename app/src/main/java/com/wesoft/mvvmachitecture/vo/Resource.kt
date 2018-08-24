package com.wesoft.mvvmachitecture.vo

/**
 * Created by james.li on 2018/8/24.
 */
sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    class Success<out T>(val data: T) : Resource<T>()
    class Failure<out T>(val throwable: Throwable) : Resource<T>()
}