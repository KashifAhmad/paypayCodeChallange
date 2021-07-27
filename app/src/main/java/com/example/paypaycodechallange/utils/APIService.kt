package com.example.paypaycodechallange.utils

import com.example.paypaycodechallange.models.CurrencyExchangeResponse
import com.techease.ecommerce.networking.Constants
import retrofit2.Response
import retrofit2.http.*


interface APIService {
    @GET("/live?")
     fun checkCurrencyRate(
        @Query("access_key") accessKey: String
    ): Response<CurrencyExchangeResponse>

}