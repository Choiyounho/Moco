package com.soten.data.di

import com.soten.data.network.repository.CoinRepositoryImpl
import com.soten.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindsCoinRepository(repo: CoinRepositoryImpl): CoinRepository
}
