package com.madrat.kursovaya.util

import android.content.Context
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// RecyclerView
fun RecyclerView.linearManager() {
    this.layoutManager = LinearLayoutManager(context)
}

inline fun EditText.hideKeyboardAndClearFocus(crossinline function: () -> Unit) {
    this.setOnEditorActionListener { textView, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            val inputMethodManager = this.context.getSystemService(
                Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(textView.windowToken, 0)
            this.isFocusable = false
            this.isFocusableInTouchMode = true
            function()
            return@setOnEditorActionListener true
        }
        false
    }
}