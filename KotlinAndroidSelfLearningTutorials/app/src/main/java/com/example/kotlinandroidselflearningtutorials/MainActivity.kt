package com.example.kotlinandroidselflearningtutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.tutorials.APIIntegrationsWithRetrofit.EmployeeAPIService
import com.tutorials.APIIntegrationsWithRetrofit.EmployeeIdResponse
import com.tutorials.APIIntegrationsWithRetrofit.EmployeeResponse
import com.tutorials.BasicKotlinAndroid.BasicKotlinAndroidActivity
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var textView: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = this.findViewById(R.id.textView);
    }

    fun GetEmployeeData()
    {
        var callEmployeeService = EmployeeAPIService.create().getEmployees();
        callEmployeeService.enqueue(object: retrofit2.Callback<EmployeeResponse>{
            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println(t.message)
                callEmployeeService.cancel()
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
                callEmployeeService.cancel()
            }
        } )
    }

    fun GetEmployeeDataByID(id: String)
    {
        UpdateTextView("Loading")
        var callEmployeeService = EmployeeAPIService.create().getEmployeesById(id);
        callEmployeeService.enqueue(object: retrofit2.Callback<EmployeeIdResponse>{
            override fun onFailure(call: Call<EmployeeIdResponse>, t: Throwable) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println(t.message)
                UpdateTextView("Failed")
                callEmployeeService.cancel()
            }

            override fun onResponse(call: Call<EmployeeIdResponse>, response: Response<EmployeeIdResponse>) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                UpdateTextView("Success")
                var employeeResponse: EmployeeIdResponse? = response.body()
                var employee = employeeResponse?.employee;
                if(employee != null)
                {
                    println("Employee Name:  ${employee.employeeName} \n" +
                            "Employee Salary:  ${employee.employeeSalary} \n" +
                            "Employee Age:  ${employee.employeeAge} \n" +
                            "Employee Image:  ${employee.employeeImage}")
                    }
                callEmployeeService.cancel()
            }
        } )
    }

    fun UpdateTextView(value: String)
    {
        textView?.text = value
    }

    fun TestButtonClicked(view: View)
    {
        if(view != null)
        {
            var butttonView: Button? = view as Button;
            if(butttonView != null)
            {
                //GetEmployeeData()
                GetEmployeeDataByID("4")
            }
        }
    }

    fun OnButtonClicked(view: View)
    {
        if(view != null)
        {
            var buttonView: Button? = view as Button;
            try
            {
                when(buttonView?.text)
                {
                    "Open Another Activity" ->
                    {
                        var i = 0;

                        var androidActivityIntent = Intent(this, BasicKotlinAndroidActivity::class.java)
                        startActivity(androidActivityIntent)
                    }
                    else ->
                    {

                    }
                }
            }
            catch (ex: Exception)
            {
                var msg = ex.message + "\n" + ex.stackTrace;
                println(msg)
            }
        }
    }

//    fun main(args: Array<String>)
//    {
//        DataDisplay();
//        GetData();
//    }
}
