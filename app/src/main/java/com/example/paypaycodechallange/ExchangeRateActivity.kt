package com.example.paypaycodechallange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paypaycodechallange.ui.main.ExchangeRateFragment

class ExchangeRateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exchange_rate_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ExchangeRateFragment.newInstance())
                .commitNow()
        }
    }
}