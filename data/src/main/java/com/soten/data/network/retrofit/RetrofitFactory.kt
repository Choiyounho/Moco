package com.soten.data.network.retrofit

import com.soten.data.network.retrofit.Url.UPBIT_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

internal object RetrofitFactory {

    fun create(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(UPBIT_URL)
            .client(createOkhttpClient())
            .addCallAdapterFactory(ApiResultCallAdapterFactory())
            .addConverterFactory(KotlinxConverterFactory.create())
            .build()
    }

    private fun createOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY),
            )
            .build()
    }
}
