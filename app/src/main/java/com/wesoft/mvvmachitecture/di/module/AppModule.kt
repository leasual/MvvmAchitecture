package com.wesoft.mvvmachitecture.di.module

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.wesoft.mvvmachitecture.App
import com.wesoft.mvvmachitecture.extension.PreferencesUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by james.li on 2018/8/21.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(app: App): PreferencesUtil = PreferencesUtil(app)

}