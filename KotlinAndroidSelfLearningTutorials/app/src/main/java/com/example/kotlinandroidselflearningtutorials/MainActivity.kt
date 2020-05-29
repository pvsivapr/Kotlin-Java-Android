package com.example.kotlinandroidselflearningtutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.tutorials.APIIntegrationsWithRetrofit.EmployeeAPIService
import com.tutorials.APIIntegrationsWithRetrofit.EmployeeResponse
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun GetData()
    {
        var callEmployeeService = EmployeeAPIService.create().getEmployees();
        callEmployeeService.enqueue(object: retrofit2.Callback<EmployeeResponse>{
            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println(t.message)
            }

            override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                var employeeResponse: EmployeeResponse? = response.body()
                var employees = employeeResponse?.employees;
                if(employees != null)
                {
//                employees.forEach()
                    employees.forEach {
                        println("Employee Name:  ${it.employeeName} \n" +
                                "Employee Salary:  ${it.employeeSalary} \n" +
                                "Employee Age:  ${it.employeeAge} \n" +
                                "Employee Image:  ${it.employeeImage}")
                    }
                }
            }
        } )
    }

    fun TestButtonClicked(view: View)
    {
        if(view != null)
        {
            var butttonView: Button? = view as Button;
            if(butttonView != null)
            {
                GetData()
            }
        }
    }

//    fun main(args: Array<String>)
//    {
//        DataDisplay();
//        GetData();
//    }
}
