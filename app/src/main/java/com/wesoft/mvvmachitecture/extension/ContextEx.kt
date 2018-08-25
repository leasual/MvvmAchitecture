package com.wesoft.mvvmachitecture.extension

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

/**
 * Created by james on 2018/8/25.
 */

fun Context.isNetworkAvailable(): Boolean {
    val connectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    return connectionManager?.activeNetworkInfo?.isConnected ?: false
}

fun Context.toast(message: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, time).show()
}