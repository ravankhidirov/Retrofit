package com.ravankhidirov.retrofit.api

import com.ravankhidirov.retrofit.model.Results
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("marvel")
    fun getsuperHeroes(): Call<List<Results>>
}