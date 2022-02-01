package com.example.superheroes

import android.app.Application
import com.example.superheroes.retrofit.ApiDescriptionInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class MyApplication: Application() {

    var retrofit: Retrofit? = null
    var api: ApiDescriptionInterface? = null

    override fun onCreate() {
        super.onCreate()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okhttp3 = OkHttpClient.Builder().apply {
            readTimeout(20, TimeUnit.SECONDS)
            writeTimeout(20, TimeUnit.SECONDS)
            connectTimeout(20, TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }.build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/4747716308616166/")
            .client(okhttp3)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit?.create(ApiDescriptionInterface::class.java)
    }


}