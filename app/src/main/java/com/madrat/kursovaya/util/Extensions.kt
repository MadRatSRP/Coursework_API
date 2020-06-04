package com.madrat.kursovaya.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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