package com.soten.domain.repository

import com.soten.domain.model.Coin

interface CoinRepository {

    suspend fun fetchAllCoin(): Result<List<Coin>>
}