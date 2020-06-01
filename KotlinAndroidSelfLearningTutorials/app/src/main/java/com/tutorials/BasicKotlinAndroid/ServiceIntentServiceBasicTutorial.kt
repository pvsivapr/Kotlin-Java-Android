package com.tutorials.BasicKotlinAndroid

import android.app.IntentService
import android.content.Intent
import com.Sivaprasad.CustomControls.ToastMessage

class ServiceIntentServiceBasicTutorial(name: String?) : IntentService(name)
{
    override fun onHandleIntent(intent: Intent?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        println("ServiceBasicTutorial: Service Created")
        ToastMessage.displayShort(this, "ServiceBasicTutorial: Service Created")
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        println("ServiceBasicTutorial: Service Started")
        ToastMessage.displayLong(this, "ServiceBasicTutorial: Service Started")
        super.onStart(intent, startId)
    }

    override fun onDestroy() {
        println("ServiceBasicTutorial: Service Destroyed")
        ToastMessage.displayLong(this, "ServiceBasicTutorial: Service Destroyed")
        super.onDestroy()
    }
}