package com.wesoft.mvvmachitecture.extension

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Singleton

/**
 * Created by james on 2018/8/25.
 */


private const val PREFS_FILE = "default.preferences"

@Singleton
class PreferencesUtil(context: Context) {
    val defaultPreferences: SharedPreferences = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
}

inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}

fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
    val key = pair.first
    val value = pair.second
    when(value) {
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Boolean -> putBoolean(key, value)
        is Long -> putLong(key, value)
        is Float -> putFloat(key, value)
        else -> error("Only primitive types can be stored in SharedPreferences")
    }
}

fun SharedPreferences.getString(key: String): String = this.getString(key, "")

fun SharedPreferences.putString(key: String, value: String?) = this.edit { putString(key, value) }


fun SharedPreferences.getLong(key: String, defaultValue: Long): Long = this.getLong(key, defaultValue)

fun SharedPreferences.putLong(key: String, value: Long) = this.edit { putLong(key, value) }

fun SharedPreferences.getInt(key: String, defaultValue: Int): Int = this.getInt(key, defaultValue)

fun SharedPreferences.putInt(key: String, value: Int) = this.edit { putInt(key, value) }

fun SharedPreferences.getBoolean(key: String, defaultValue: Boolean): Boolean = this.getBoolean(key, defaultValue)

fun SharedPreferences.putBoolean(key: String, value: Boolean) = this.edit { putBoolean(key, value) }