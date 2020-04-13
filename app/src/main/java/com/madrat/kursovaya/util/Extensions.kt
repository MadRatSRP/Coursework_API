package com.madrat.kursovaya.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// ViewGroup
fun ViewGroup.inflate(layoutRes: Int): View
        = LayoutInflater.from(context).inflate(layoutRes, this, false)

// RecyclerView
fun RecyclerView.linearManager() {
    this.layoutManager = LinearLayoutManager(context)
}