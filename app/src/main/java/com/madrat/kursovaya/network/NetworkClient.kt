package com.madrat.kursovaya.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.madrat.kursovaya.R
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkClient(private val context: Context) {
    private fun formRetrofitInstance(): Retrofit {
        val url = context.getString(R.string.URL)

        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

            // Chucker
            .addInterceptor(ChuckerInterceptor(context))
            .build()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }

    fun instance(): NetworkInterface {
        return formRetrofitInstance().create(NetworkInterface::class.java)
    }
}