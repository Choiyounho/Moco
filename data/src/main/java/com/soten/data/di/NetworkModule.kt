package com.soten.data.di

import com.soten.data.network.api.UpbitApi
import com.soten.data.network.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return RetrofitFactory.create()
    }

    @Provides
    fun providesUpbitApi(retrofit: Retrofit): UpbitApi {
        return retrofit.create(UpbitApi::class.java)
    }
}
