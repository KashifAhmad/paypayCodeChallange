package com.example.paypaycodechallange.utils

class BaseNetworking {
   var services: APIService? = null

  fun apiServices(): APIService? {
        services = APIClient.getClient()!!.create(APIService::class.java)
        return services
    }
}