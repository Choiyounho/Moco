package com.soten.data.mapper

import com.soten.data.network.response.CoinResponse
import com.soten.domain.model.Coin

internal fun CoinResponse.toDomain(): Coin {
    return Coin(market, koranName, englishName)
}
