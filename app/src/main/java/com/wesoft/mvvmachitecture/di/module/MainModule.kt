package com.wesoft.mvvmachitecture.di.module

import com.wesoft.mvvmachitecture.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by james on 2018/8/26.
 */
@Module

abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment
}