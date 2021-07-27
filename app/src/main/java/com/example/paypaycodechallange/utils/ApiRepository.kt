package com.example.paypaycodechallange.utils

import android.content.Context
import com.example.paypaycodechallange.models.CurrencyExchangeResponse
import com.techease.ecommerce.networking.Constants


class ApiRepository : SafeApiRequest() {

    suspend fun getExchangeRate(
    ): CurrencyExchangeResponse {
        return apiRequest {
            BaseNetworking().apiServices()!!
                .checkCurrencyRate(Constants.ACESS_KEY)
        }
    }
}