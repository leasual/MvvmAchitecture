package com.wesoft.mvvmachitecture.di
import dagger.MapKey
import kotlin.reflect.KClass
import android.arch.lifecycle.ViewModel

/**
 * Created by james.li on 2018/8/21.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)