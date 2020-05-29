package com.tutorials.APIIntegrationsWithRetrofit

import com.google.gson.annotations.SerializedName

//This is our JSON object from url "http://dummy.restapiexample.com/api/v1/employees"
/*
{
  "status": "success",
  "data": [
    {
      "id": "1",
      "employee_name": "Tiger Nixon",
      "employee_salary": "320800",
      "employee_age": "61",
      "profile_image": ""
    }
  ]
}
*/

data class EmployeeResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val employees: List<Employee>
)

data class Employee(
    @SerializedName("employee_name")
    val employeeName: String,

    @SerializedName("employee_salary")
    val employeeSalary: String,

    @SerializedName("employee_age")
    val employeeAge: String,

    @SerializedName("profile_image")
    val employeeImage: String
)