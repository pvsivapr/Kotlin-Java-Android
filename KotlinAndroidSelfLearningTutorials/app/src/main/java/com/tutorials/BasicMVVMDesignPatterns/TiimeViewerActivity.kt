package com.tutorials.BasicMVVMDesignPatterns

import android.database.Observable
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinandroidselflearningtutorials.R
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

class TimeViewerActivity : AppCompatActivity()
{
    var timeText : TextView? = null;
    var timeViewerViewModel: TimeViewerViewModel? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_viewer)

        timeText = findViewById(R.id.timTextValue)

        val calendar: Calendar = Calendar.getInstance()

        timeViewerViewModel = ViewModelProvider(this).get(TimeViewerViewModel::class.java)
        timeViewerViewModel?.timerValue?.observe(this, androidx.lifecycle.Observer<Long> { value ->
            calendar?.timeInMillis = value!!
            timeText?.text = calendar.time.toString()
        })

    }

    fun StartServiceButtonClicked(view: View)
    {
        timeViewerViewModel?.StartTimer()
    }
    fun StopServiceButtonClicked(view: View)
    {
        timeViewerViewModel?.StopTimer()
    }
}

class TimeViewerViewModel : ViewModel() {
    private var timer : Timer? = null

    val timerValue = MutableLiveData<Long>();

    init {
        Log.e("Model", "initialize")
        timerValue.value = System.currentTimeMillis()
////        timer.schedule(5000){
////            timerValue.postValue(System.currentTimeMillis())
////        }
//        timer.scheduleAtFixedRate(1000, 1000 ){
//            timerValue.postValue(System.currentTimeMillis())
//        }
    }

    fun StartTimer()
    {
        try {
//        timer.schedule(5000){
//            timerValue.postValue(System.currentTimeMillis())
//        }
            timer = Timer()
        timer?.scheduleAtFixedRate(1000, 1000 ){
            timerValue.postValue(System.currentTimeMillis())
        }
        }
        catch (ex: Exception)
        {
            var msg = ex.message + "\n" + ex.stackTrace;
            println(msg);
        }
    }

    fun StopTimer()
    {
        try {
            timer?.cancel();
        }
        catch (ex: Exception)
        {
            var msg = ex.message + "\n" + ex.stackTrace;
        }
    }
}