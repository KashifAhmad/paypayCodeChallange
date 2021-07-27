package com.example.paypaycodechallange.ui.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.paypaycodechallange.R


class ExchangeRateFragment : Fragment() {

    companion object {
        fun newInstance() = ExchangeRateFragment()
    }

    private lateinit var viewModel: ExchangeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(ExchangeViewModel::class.java)
        viewModel.getExchangeRate()
        return inflater.inflate(R.layout.exchange_fragment, container, false)
    }

}