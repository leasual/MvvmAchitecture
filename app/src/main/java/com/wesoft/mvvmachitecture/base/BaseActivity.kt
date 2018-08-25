package com.wesoft.mvvmachitecture.base

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.wesoft.mvvmachitecture.extension.PreferencesUtil
import com.wesoft.mvvmachitecture.vo.ViewModelTypeResolver
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by james.li on 2018/8/21.
 */

abstract class BaseActivity<VM: BaseViewModel<*>, B: ViewDataBinding>: RxAppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    lateinit var viewModel: VM

    lateinit var mBinding: B

    @Inject
    lateinit var mPreferences: PreferencesUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val viewModelType = ViewModelTypeResolver.findViewModelType<BaseViewModel<*>>(javaClass)
        if(viewModelType != null) {
            @Suppress("UNCHECKED_CAST")
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType) as VM
        }
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        setupViews()

        viewModel.isLoading.observe(this, Observer { isLoading ->

        })
    }

    @LayoutRes
    abstract fun getLayoutId() : Int

    abstract fun setupViews()
}