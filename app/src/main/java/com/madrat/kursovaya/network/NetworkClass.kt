package com.madrat.kursovaya.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.madrat.kursovaya.R
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class NetworkClient {
    companion object {
        private fun getRetrofit(context: Context): Retrofit? {
            var retrofit: Retrofit? = null
            val url = context.getString(R.string.URL)

            if (retrofit == null) {
                val client = returnOkHTTPInstance(context)

                retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    //.addConverterFactory(GsonConverterFactory.create())
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
            }
            return retrofit
        }

        private fun returnOkHTTPInstance(context: Context): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)

                // Chucker
                .addInterceptor(ChuckerInterceptor(context))
                .build()
        }

        fun instance(context: Context)
                = getRetrofit(context)?.create(NetworkInterface::class.java)
    }
}