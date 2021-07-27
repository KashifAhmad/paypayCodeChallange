package com.example.paypaycodechallange.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyExchangeResponse(
    @Json(name = "privacy")
    val privacy: String,
    @Json(name = "quotes")
    val quotes: Quotes,
    @Json(name = "source")
    val source: String,
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "terms")
    val terms: String,
    @Json(name = "timestamp")
    val timestamp: Int
)