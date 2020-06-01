package com.tutorials.BasicKotlinAndroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinandroidselflearningtutorials.R

class BasicKotlinAndroidActivity: AppCompatActivity(){

    var serviceBasic_Intent: Intent? = null;
    var serviceIntentService_Intent: Intent? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_kotlin_android)
    }

    fun StartServiceButtonClicked(view: View)
    {
        if(view != null)
        {
            var butttonView: Button? = view as Button;
            if(butttonView != null)
            {
                serviceBasic_Intent = Intent(this, ServiceBasicTutorial::class.java)
                serviceBasic_Intent!!.putExtra("TestString", "Test")
                startService(serviceBasic_Intent);
            }
        }
    }

    fun StopServiceButtonClicked(view: View)
    {
        var butttonView: Button? = view as Button;
        if(butttonView != null)
        {
            when(butttonView.text)
            {
                "Stop Service" -> {
                    if (serviceBasic_Intent != null) {
                        stopService(serviceBasic_Intent)
                    }
                }
                "Start Intent Service" -> {
                    serviceIntentService_Intent = Intent(this, ServiceIntentServiceBasicTutorial("testIntentService")::class.java)
                    startService(serviceIntentService_Intent)
                }
                "Stop Intent Service" -> {
                    if (serviceIntentService_Intent != null) {
                        //stopService(serviceIntentService_Intent)
                    }
                }
                else -> {
                    println("")
                }

            }
        }
    }
}