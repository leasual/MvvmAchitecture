package com.wesoft.mvvmachitecture.extension

import android.content.Context
import android.support.annotation.IntDef
import android.support.annotation.IntegerRes
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager

/**
 * Created by james on 2018/8/26.
 */

enum class Display {
    HORIZONTAL, VERTICAL
}

enum class Direction {
    GRID, LINEAR, STAGGERD
}

fun RecyclerView.bindLinearLayout(context: Context, adapter: RecyclerView.Adapter<*>, display: Display = Display.VERTICAL) {
    if (display == Display.VERTICAL) {
        this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    } else {
        this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
    this.adapter = adapter
}

fun RecyclerView.bindGridLayout(context: Context, adapter: RecyclerView.Adapter<*>, spanCount: Int = 2) {
    this.layoutManager = GridLayoutManager(context, spanCount)
    this.adapter = adapter
}

fun RecyclerView.bindStaggeredGridLayout(adapter: RecyclerView.Adapter<*>, spanCount: Int = 2, display: Display = Display.VERTICAL) {
    if (display == Display.VERTICAL) {
        this.layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
    }else {
        this.layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL)
    }
    this.adapter = adapter
}
