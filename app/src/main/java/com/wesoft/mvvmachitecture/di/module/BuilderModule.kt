package com.wesoft.mvvmachitecture.di.module

import com.wesoft.mvvmachitecture.ui.main.MainActivity
import com.wesoft.mvvmachitecture.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by james.li on 2018/8/21.
 */
@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun mainActivity(): MainActivity

    // support fragment injection
    //@ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    //internal abstract fun mainActivity(): MainActivity
}