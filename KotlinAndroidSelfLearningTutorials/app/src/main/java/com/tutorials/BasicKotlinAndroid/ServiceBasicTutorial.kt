package com.tutorials.BasicKotlinAndroid

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.view.Gravity
import android.widget.Toast

class ServiceBasicTutorial : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return null;
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("ServiceBasicTutorial: Service Started")
        displayToast("ServiceBasicTutorial: Service Started")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        println("ServiceBasicTutorial: Service Created")
        displayToast("ServiceBasicTutorial: Service Created")
        super.onCreate()
    }

    override fun onDestroy() {
        println("ServiceBasicTutorial: Service Destroyed")
        displayToast("ServiceBasicTutorial: Service Destroyed")
        super.onDestroy()
    }

    fun displayToast(message: String)
    {
        val toastMessage = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toastMessage.setGravity(Gravity.CENTER, 0,0)
        toastMessage.show()
    }
}

fun main(args: Array<String>)
{

}