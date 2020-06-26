package com.tutorials.BasicKotlinAndroid

fun main(args: Array<String>)
{
    Introduction()
}

fun Introduction()
{
    println("14th May 2020")
    println("::::::::::::::: BASICS OF ANDROID KOTLIN :::::::::::::::")

    println("Four major components of Android to build an application are : ")
    println("\t Activities, Services, Content-Providers, Broadcast-Receivers")

    println("\n\n\t Activities: ")
    println("\t Create a Activity class as \"class BasicKotlinAndroidActivity: AppCompatActivity()\" ")
    println("Now configure the Activity in \"AndroidManifest.xml\"")
    println("\t\t Add Activity in \"AndroidManifest.xml\" as \"<activity android:name=\"com.tutorials.BasicKotlinAndroid.BasicKotlinAndroidActivity\">\n" +
            "        </activity>\"")

    println("\n\n\t Services: ")
    println("\n\t 1)Services: ")
    println("\t Create a Service class as \"class ServiceBasicTutorial : Service()\" ")
    println("Now configure the Service in \"AndroidManifest.xml\"")
    println("\t\t Add Service in \"AndroidManifest.xml\" as \"<service android:name=\"com.yyy.yyy.service_class_name\"/>\"")
    println("Note: you have to start and stop service, if we don't stop the service, it will run still OS stops it ")

    println("\n\t 1)IntentServices: ")
    println("In simple service we have to stop it manually, It is good for small periods, It also works on main thread which effects the app")
    println("To overcome those problems, we can use IntentService")
    println("This creates a new thread, It will be stopped automatically after the action is complete")
    println("Intent Service is used to download large files in the background")
    println("Each IntentService can handle multiple intents: which means we can run start the same IntentService multiple times in a queue process (sequentially) not simultaneously")
    println("For an Intent Service we have to give a name to distinguish between other services")
    println("Intent Service runs on a new worker thread, not on main thread")

    println("\n\t 2)JobServices: ")
    println("\n\t 1)JobScheduler: ")

}