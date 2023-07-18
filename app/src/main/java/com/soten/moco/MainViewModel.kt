package com.soten.moco

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soten.domain.model.Coin
import com.soten.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
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

    private val error = MutableSharedFlow<Boolean>()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            coinRepository.fetchAllCoin()
                .onSuccess {
                    Log.e("ASDASD", "$it")
                    _coins.update { it }
                }.onFailure {
                    Log.e("ASDASD", "실패")
                }
        }
    }
}