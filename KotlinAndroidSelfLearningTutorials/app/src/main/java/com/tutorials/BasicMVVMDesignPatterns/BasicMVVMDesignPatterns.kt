package com.tutorials.BasicMVVMDesignPatterns

fun main(args: Array<String>)
{
    DataDisplay();
}

fun DataDisplay()
{
    println("19, 20th May 2020")
    println("::::::::::::::: MVVM Design Pattern :::::::::::::::")

    println("Below displayed are the components needed")
    println("{\n" +
            "\".xml\" file for UI" +
            "\"Activity\" file to handle the xml" +
            "\"ViewModel\" to do data logic" +
            "\"LiveData\" to update the view on data changes" +
            "\"DataClass\" to serve as a model class" +
            "}")

    println("Steps :")

    println("\t 1) Install packages in build.gradle -> ")
    println("\t\t a)implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:<lifecycle_version>'")
    println("\t\t b)implementation 'androidx.lifecycle:lifecycle-livedata-ktx:<lifecycle_version>'")
    println("\t\t b)add google() repository as  \n allprojects{\nrepositories{\n google() \n}\n}")

    println("\t 2) ViewModel\"")
    println("\t\t Create a class for view model and extend to ViewModel\"")
    println("\t\t Initialize this view model in activity by : var viewmodelObject = ViewModelProvider(this).get(OurViewModelClass::class.java)")

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