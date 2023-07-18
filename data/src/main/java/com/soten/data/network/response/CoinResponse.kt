package com.soten.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinResponse(
    val market: String,
    @SerialName("korean_name")
    val koranName: String,
    @SerialName("english_name")
    val englishName: String,
)
