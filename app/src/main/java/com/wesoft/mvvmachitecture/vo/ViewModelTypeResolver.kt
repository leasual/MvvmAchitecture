package com.wesoft.mvvmachitecture.vo

import android.arch.lifecycle.ViewModel
import java.lang.reflect.ParameterizedType

/**
 * Created by james on 2018/8/25.
 */

object ViewModelTypeResolver {


    fun findViewModelType(cls: Class<*>): Class<out ViewModel>? {
        var parameterizedType: ParameterizedType? = null

        if (cls.genericSuperclass is ParameterizedType) {
            parameterizedType = cls.genericSuperclass as ParameterizedType
        }

        if (parameterizedType == null) {
            return null
        }

        parameterizedType.actualTypeArguments
                .filter {
                    it is Class<*>
                            && it !== ViewModel::class.java
                            && ViewModel::class.java.isAssignableFrom(it)
                }.forEach {
            @Suppress("UNCHECKED_CAST")
            return it as Class<out ViewModel>
        }

        return null
    }

}