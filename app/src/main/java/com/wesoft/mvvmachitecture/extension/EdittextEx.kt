package com.wesoft.mvvmachitecture.extension

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by james on 2018/8/24.
 */

fun EditText.asString(): String {
    return text.toString().replace('\n',' ').trim()
}

fun EditText.setMaxLen(inputMaxLen:Int){
    maxLen  = inputMaxLen
    this.filters = arrayOf(filter)
}

fun EditText.isEmpty() = (text.isEmpty() || text == null)

fun EditText.onTextChanged(after: (s: Editable) -> Unit = {},
                           before: (string: String, start: Int, count: Int, after: Int) -> Unit = { _, _, _, _ -> },
                           onTextChanged: (string: String, start: Int, count: Int, after: Int) -> Unit) =
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) = after.invoke(s)
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) =
                    before.invoke(s.toString(), start, count, after)

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = onTextChanged(s.toString(), start, before, count)
        })

fun EditText.clear() = text.clear()

fun EditText.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}

private var maxLen = 20
//输入长度限制，一个中文占位 = 两个英文占位
private val filter = InputFilter { source, start, end, dest, dstart, dend ->
    var dindex = 0
    var count = 0
    while (count <= maxLen && dindex < dest.length) {
        val c = dest[dindex++]
        count = if (c.toInt() < 128) {
            count + 1
        } else {
            count + 2
        }
    }
    if (count > maxLen) {
        return@InputFilter dest.subSequence(0, dindex - 1)
    }
    var sindex = 0
    while (count <= maxLen && sindex < source.length) {
        val c = source[sindex++]
        count += if (c.toInt() < 128) {
            1
        } else {
            2
        }
    }
    if (count > maxLen) {
        sindex--
    }
    source.subSequence(0, sindex)
}