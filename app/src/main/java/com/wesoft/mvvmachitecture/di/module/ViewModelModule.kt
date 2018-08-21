package com.wesoft.mvvmachitecture.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.wesoft.mvvmachitecture.di.DaggerViewModelFactory
import com.wesoft.mvvmachitecture.di.ViewModelKey
import com.wesoft.mvvmachitecture.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by james.li on 2018/8/21.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}