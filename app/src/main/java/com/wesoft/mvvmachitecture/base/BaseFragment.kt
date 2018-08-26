package com.wesoft.mvvmachitecture.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wesoft.mvvmachitecture.extension.PreferencesUtil
import com.wesoft.mvvmachitecture.vo.ViewModelTypeResolver
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by james.li on 2018/8/21.
 */

abstract class BaseFragment<VM: BaseViewModel<*>, B: ViewDataBinding>: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    lateinit var mBinding: B

    @Inject
    lateinit var mPreferences: PreferencesUtil

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val viewModelType = ViewModelTypeResolver.findViewModelType<BaseViewModel<*>>(javaClass)
        if(viewModelType != null) {
            @Suppress("UNCHECKED_CAST")
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType) as VM
        }
        observeData()
        setupViews()
        return mBinding.root
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @LayoutRes
    abstract fun getLayoutId() : Int

    abstract fun setupViews()

    abstract fun observeData()
}