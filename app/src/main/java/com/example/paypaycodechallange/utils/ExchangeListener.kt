package com.example.paypaycodechallange.utils

import com.example.paypaycodechallange.models.CurrencyExchangeResponse


interface ExchangeListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
    fun getCurrencyResponse(response: CurrencyExchangeResponse)


}