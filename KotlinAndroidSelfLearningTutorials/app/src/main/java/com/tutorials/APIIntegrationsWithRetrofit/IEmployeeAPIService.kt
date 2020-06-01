package com.tutorials.APIIntegrationsWithRetrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IEmployeeAPIService
{
    @GET("api/v1/employees")
    fun getEmployees(): Call<EmployeeResponse>

    @GET("api/v1/employee/{id}")
    fun getEmployeesById(@Path("id") id: String ): Call<EmployeeIdResponse>

    @POST("api/v1/create")
    fun createEmployee(@Body employee: Employee): Call<EmployeeIdResponse>
}