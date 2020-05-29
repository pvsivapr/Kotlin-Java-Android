package com.tutorials.APIIntegrationsWithRetrofit

import retrofit2.Call
import retrofit2.http.GET

interface IEmployeeAPIService
{
    @GET("api/v1/employees")
    fun getEmployees(): Call<EmployeeResponse>


}