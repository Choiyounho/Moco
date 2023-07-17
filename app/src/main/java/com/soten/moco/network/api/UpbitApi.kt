package com.soten.moco.network.api

import com.soten.moco.network.ApiResult
import com.soten.moco.network.response.CoinResponse
import retrofit2.http.GET

interface UpbitApi {

    @GET("v1/market/all")
    suspend fun fetchAllCoins(): ApiResult<List<CoinResponse>>
}
