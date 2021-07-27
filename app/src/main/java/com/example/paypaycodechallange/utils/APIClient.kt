package com.example.paypaycodechallange.utils

import com.google.gson.GsonBuilder
import com.techease.ecommerce.networking.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object APIClient {
    const val BASE_URL = Constants.BASE_URL
    private var retrofit: Retrofit? = null

    // Customize the request

    fun getClient(): Retrofit? {

        val gson = GsonBuilder()
            .setLenient()
            .create()
        val httpClient = OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            // Customize the request
            val request = original.newBuilder()
                .header("Accept", "application/json")
//                .header("x-api-version", "P-0.1")
                .build()

            // Customize or return the response
            chain.proceed(request)
        }
        val OkHttpClient = httpClient.build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClient)
                .build()
        }
        return retrofit
    }

    fun getClient(token: String): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val interceptor1 = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        val httpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(interceptor1)
            .addInterceptor { chain ->
                val original = chain.request()

                // Customize the request
                val request = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer $token")
                    .header("x-api-version", "P-0.1")

                    .method(original.method, original.body)
                    .build()

                // Customize or return the response
                chain.proceed(request)
            }
        val OkHttpClient = httpClient.build()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient)
            .build()
        return retrofit
    }
}