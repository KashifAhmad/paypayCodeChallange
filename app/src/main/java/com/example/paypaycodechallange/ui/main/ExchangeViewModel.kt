package com.example.paypaycodechallange.ui.main

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.paypaycodechallange.utils.ApiException
import com.example.paypaycodechallange.utils.ApiRepository
import com.example.paypaycodechallange.utils.Coroutines
import com.example.paypaycodechallange.utils.ExchangeListener

class ExchangeViewModel(application: Application) : AndroidViewModel(application) {
    var listener: ExchangeListener? = null
    fun getExchangeRate() {
        Coroutines.main {
            try {
               ApiRepository().getExchangeRate(
                ).let {
                    Log.d("zma values", it.quotes.toString())
                }
            }catch (e:ApiException){
                listener?.onFailure(e.message.toString())
            }
        }
    }
}