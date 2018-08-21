package com.wesoft.mvvmachitecture.di.component

import com.wesoft.mvvmachitecture.App
import com.wesoft.mvvmachitecture.di.module.AppModule
import com.wesoft.mvvmachitecture.di.module.BuilderModule
import com.wesoft.mvvmachitecture.di.module.NetworkModule
import com.wesoft.mvvmachitecture.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by james.li on 2018/8/21.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    BuilderModule::class,
    NetworkModule::class,
    ViewModelModule::class
])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>()
}