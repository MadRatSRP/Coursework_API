package com.madrat.kursovaya.util

import retrofit2.Retrofit

object AppDependencies {
    var retrofit: Retrofit? = null
    
    fun dismiss() {
        retrofit = null
    }
}