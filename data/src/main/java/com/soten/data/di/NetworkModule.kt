//package com.soten.data.di
//
//import com.soten.moco.network.api.UpbitApi
//import com.soten.moco.network.retrofit.RetrofitFactory
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//
//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    @Provides
//    fun providesRetrofit(): Retrofit {
//        return com.soten.moco.network.retrofit.RetrofitFactory.create()
//    }
//
//    @Provides
//    fun providesUpbitApi(retrofit: Retrofit): com.soten.moco.network.api.UpbitApi {
//        return retrofit.create(com.soten.moco.network.api.UpbitApi::class.java)
//    }
//}
