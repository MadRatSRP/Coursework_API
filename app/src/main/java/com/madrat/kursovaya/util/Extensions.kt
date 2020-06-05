package com.madrat.kursovaya.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// ViewGroup
fun ViewGroup.inflate(layoutRes: Int): View
        = LayoutInflater.from(context).inflate(layoutRes, this, false)

// RecyclerView
fun RecyclerView.linearManager() {
    this.layoutManager = LinearLayoutManager(context)
}

// ImageView
fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(context).load(url).into(this)
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