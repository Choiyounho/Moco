package com.soten.moco

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soten.domain.model.Coin
import com.soten.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val coinRepository: CoinRepository
) : ViewModel() {

    private val _coins = MutableStateFlow<List<Coin>>(emptyList())
    val coin = _coins.asStateFlow()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            coinRepository.fetchAllCoin()
                .onSuccess { coins ->
                    _coins.update { coins }
                }
        }
    }
}