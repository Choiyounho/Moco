package com.soten.moco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.soten.moco.network.api.UpbitApi
import com.soten.moco.network.retrofit.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = RetrofitFactory.create().create(UpbitApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val result = test.fetchAllCoins()

            Log.e("ADSADSASD", result.toString())
        }
    }
}
