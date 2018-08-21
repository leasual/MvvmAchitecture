package com.wesoft.mvvmachitecture.ui.main

import android.os.Bundle
import android.support.annotation.MainThread
import android.support.v7.app.AppCompatActivity
import com.wesoft.mvvmachitecture.R

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
