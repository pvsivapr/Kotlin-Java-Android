package com.nytimes.uiactivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nytimes.R

class IntroPageActivity : AppCompatActivity()
{
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_page)
        try {
            navController = Navigation.findNavController(this, R.id.fragment_host_area)
        }catch (ex: Exception)
        {
            ex.printStackTrace()
        }
    }
}