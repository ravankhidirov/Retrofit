package com.ravankhidirov.retrofit.network

import com.ravankhidirov.retrofit.Constants
import com.ravankhidirov.retrofit.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient private constructor() {
    private val myApi: ApiInterface

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(ApiInterface::class.java)
    }

    fun getMyApi(): ApiInterface {
        return myApi
    }

    companion object {
        @get:Synchronized
        var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }
}