package com.soten.data.network.repository

import android.util.Log
import com.soten.data.mapper.toDomain
import com.soten.data.network.ApiResult
import com.soten.data.network.api.UpbitApi
import com.soten.domain.model.Coin
import com.soten.domain.repository.CoinRepository
import javax.inject.Inject

internal class CoinRepositoryImpl @Inject constructor(
    private val upbitApi: UpbitApi
) : CoinRepository {

    override suspend fun fetchAllCoin(): Result<List<Coin>> {
        val apiResult = upbitApi.fetchAllCoins()

        return when (apiResult) {
            is ApiResult.Success -> {
                val value = apiResult.value?.map {
                    it.toDomain()
                } ?: emptyList()
                Result.success(value)
            }

            is ApiResult.Failure -> Result.failure(IllegalStateException("code = ${apiResult.code}, error = ${apiResult.message}"))
            is ApiResult.NetworkError -> Result.failure(apiResult.exception)
            is ApiResult.Unexpected -> Result.failure(apiResult.t ?: UnknownError())
        }
    }
}
