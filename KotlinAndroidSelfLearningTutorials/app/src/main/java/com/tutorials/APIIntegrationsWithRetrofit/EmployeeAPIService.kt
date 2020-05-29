package com.tutorials.APIIntegrationsWithRetrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EmployeeAPIService
{
    val httpURL = "http://dummy.restapiexample.com"

    fun create(): IEmployeeAPIService{

        val okHttpClient = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl(httpURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(IEmployeeAPIService::class.java)
    }

}