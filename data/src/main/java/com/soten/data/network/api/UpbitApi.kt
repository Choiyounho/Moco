package com.soten.data.network.api

import com.soten.data.network.ApiResult
import com.soten.data.network.response.CoinResponse
import retrofit2.http.GET

internal interface UpbitApi {

    @GET("v1/market/all")
    suspend fun fetchAllCoins(): ApiResult<List<CoinResponse>>
}
