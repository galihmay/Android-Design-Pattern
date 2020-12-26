package com.galihmayangga.android.data.remote


import com.galihmayangga.android.data.model.News
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitApi {
    const val NEWS_URL =  "https://newsapi.org/v2/top-headlines?country=id&category=technology&apiKey=93c7682f90c5442789057ef4deca709f/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
         level = HttpLoggingInterceptor.Level.BODY
        })
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    private fun create(url: String) : Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun newsService() : NewsService {
        return create(NEWS_URL).create(NewsService::class.java)
    }
}