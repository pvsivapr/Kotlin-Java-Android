package com.tutorials.APIIntegrationsWithRetrofit

import retrofit2.Call
import retrofit2.Response

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
//    UpdateTextView("Loading")
    var callEmployeeService = EmployeeAPIService.create().getEmployeesById(id);
    callEmployeeService.enqueue(object: retrofit2.Callback<EmployeeIdResponse>{
        override fun onFailure(call: Call<EmployeeIdResponse>, t: Throwable) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            println(t.message)
//            UpdateTextView("Failed")
            callEmployeeService.cancel()
        }

        override fun onResponse(call: Call<EmployeeIdResponse>, response: Response<EmployeeIdResponse>) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

//            UpdateTextView("Success")
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

fun main(args: Array<String>)
{
    DataDisplay();
    //GetData();
    GetEmployeeData()
    GetEmployeeDataByID("4")
}

fun DataDisplay()
{
    println("13th May 2020")
    println("::::::::::::::: API INTEGRATIONS USING RETROFIT :::::::::::::::")

    println("Below displayed is our response data from the url \"http://dummy.restapiexample.com/api/v1/employees\"")
    println("{\n" +
            "  \"status\": \"success\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": \"1\",\n" +
            "      \"employee_name\": \"Tiger Nixon\",\n" +
            "      \"employee_salary\": \"320800\",\n" +
            "      \"employee_age\": \"61\",\n" +
            "      \"profile_image\": \"\"\n" +
            "    }\n" +
            "  ]\n" +
            "}")

    println("Steps :")

    println("\t 1) Install packages in build.gradle -> ")
    println("\t\t a)implementation 'com.squareup.retrofit2:retrofit:2.8.1'")
    println("\t\t b)implementation 'com.squareup.retrofit2:converter-gson:2.8.1'")

    print("\t 2) Create API model classes(data classes with annotations, these annotations helps to parse the data exactly into the respective variables), in this example to get data of employees we are creating a Employee Reponse Model class, for reference check \"EmployeeResponse\" class in \"EmployeeModel.kt\"")
    println("\t Here the annotation used id \"SerializedName\" from \"com.google.gson.annotations.SerializedName\", a pre-installed package")
    println("\t\t E.g.: \n\t\t @SerializedName(\"employee_name\")\n\t\t val employeeName: String,")
    println("\t Here \"employee_name\" is from \"API server\" and \"employeeName\" is from created by us locally, we will be using this locally created name throughout the application")

    println("\t 3) Create Interface \n\t\t For E.g.: IEmployeeAPIService, In this interface we start with a get method, here are the following steps ")
    println("\t\t a)Create a method with response of class type as \"call<ResponseType>\", \"Call\" is given by \"Retrofit\" package, this handles getting and parsing of data ")
    print("\t\t\t E.g.: check \"EmployeeResponse\" class in \"EmployeeModel.kt\" ---- ---- Method as \"fun getEmployees(): Call<EmployeeResponse>\"")
    println("\t\t b) Now for the created method add \"GET\" annotation provided by \"Retrofit\" package with \"API url\"")
    println("\t\t\t E.g.: @GET(\"api/v1/employees\")")

    println("\t This implementation part of the interface is handled by \"Retrofit\" package itself, now all we have to do is provide a basic data and call the \"Retrofit\" implemented methods to get the data by following the Steps: ")

    println("\t 4) Create a singleton class to implement the API Interface, For reference check \"EmployeeAPIService.kt\" file")
    println("\t\t a)Create a method with response of class type as \"call<ResponseType>\", \"Call\" is given by \"Retrofit\" package, this handles getting and parsing of data ")
    print("\t\t\t E.g.: check \"EmployeeResponse\" class in \"EmployeeModel.kt\" ---- ---- Method as \"fun getEmployees(): Call<EmployeeResponse>\"")
    println("\t\t b) Now for the created method add \"GET\" annotation provided by \"Retrofit\" package with \"API url\"")
    println("\t\t\t E.g.: @GET(\"api/v1/employees\")")

    println("Mistakes to be taken care :")
    println("\t 1) Only works with emulator or device as direct file does not have any configurations ")
    println("\t 2) Add Internet permission in manifest.xml ")
    println("\t 3) url should not be of \"http\", it should be \"https\" ")

    println("Issues face on this Get Service and how I resolved it")
    println("\t 1) Error due to using url with \"http\" protocol ")
    println("\t\t To resolve this add a \"xml\" folder in res and add \"network_security_config.xml\" in that \"xml\" folder")
    println("\t\t In \"network_security_config.xml\" add the following lines: ")
    println("\n\n")
    println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<network-security-config>\n" +
            "    <domain-config cleartextTrafficPermitted=\"true\">\n" +
            "        <domain includeSubdomains=\"true\">api.example.com(to be adjusted)</domain>\n" +
            "    </domain-config>\n" +
            "</network-security-config>")
    println("\n\n")
    println("\t\t Now in \"AndroidManifest.xml\" in \"<application/>\" tag add 'android:networkSecurityConfig=\"@xml/network_security_config\"' line ")
    println("\t\t If the issue still exists in \"AndroidManifest.xml\" in \"<application/>\" tag add 'android:networkSecurityConfig=\"@xml/network_security_config\"' line instead of the above line")
}