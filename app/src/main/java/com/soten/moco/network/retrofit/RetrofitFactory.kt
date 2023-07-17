package com.soten.moco.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitFactory {

    fun create(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.upbit.com/")
            .client(createOkhttpClient())
            .addCallAdapterFactory(ApiResultCallAdapterFactory())
            .addConverterFactory(Fac.create())
            .build()
    }

    private fun createOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }
}