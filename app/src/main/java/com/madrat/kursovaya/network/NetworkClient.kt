package com.madrat.kursovaya.network

import android.content.Context
import com.madrat.kursovaya.R
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.chuckerteam.chucker.api.ChuckerInterceptor
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

class NetworkClient(
    private val context: Context
) {
    private fun formRetrofitInstance(): Retrofit {
        val url = context.getString(R.string.URL)

        val client = OkHttpClient.Builder().apply {
            connectTimeout(
                10,
                TimeUnit.SECONDS
            )
            writeTimeout(
                10,
                TimeUnit.SECONDS
            )
            readTimeout(
                30,
                TimeUnit.SECONDS
            )
            addInterceptor(
                ChuckerInterceptor.Builder(context).apply {
                    alwaysReadResponseBody(true)
                }.build()
            )
        }.build()

        return Retrofit.Builder().apply {
            baseUrl(url)
            addConverterFactory(
                GsonConverterFactory.create()
            )
            addCallAdapterFactory(
                RxJava3CallAdapterFactory.create()
            )
            client(client)
        }.build()
    }

    fun instance(): NetworkInterface {
        return formRetrofitInstance().create(NetworkInterface::class.java)
    }
}