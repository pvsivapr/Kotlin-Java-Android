package com.Sivaprasad.CustomControls

import android.content.Context
import android.view.Gravity
import android.widget.Toast

object ToastMessage
{
    init {
        println("The toast service is invoked")
    }
    var message : String? = null;
    private var toastGravity: Int = Gravity.BOTTOM;
    private var x_OffSet: Int = 0;
    private var y_OffSet: Int = 0;
    fun setGravity(gravity: Int, xOffSet: Int, yOffSet: Int)
    {
        toastGravity = gravity
        x_OffSet = xOffSet
        y_OffSet = yOffSet
    }
    fun displayShort(context: Context, message: String)
    {
        displayToast(context, message, Toast.LENGTH_SHORT)
    }
    fun displayLong(context: Context, message: String)
    {
        displayToast(context, message, Toast.LENGTH_SHORT)
    }
    private fun displayToast(context: Context, message: String, duration: Int)
    {
        val toastMessage = Toast.makeText(context, message, duration)
        toastMessage.setGravity(toastGravity, x_OffSet, y_OffSet)
    }
}