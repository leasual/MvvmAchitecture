package com.wesoft.mvvmachitecture

import android.app.Activity
import android.app.Application
import com.wesoft.mvvmachitecture.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by james.li on 2018/8/21.
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerAppComponent.builder().create(this).inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    companion object {
        lateinit var instance: App
    }
}