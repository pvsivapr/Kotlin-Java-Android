package com.sivaprasad.controls

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL

class URLImage(var image_View: ImageView) : AsyncTask<String?, Void?, Bitmap?>() {
    var imageView: ImageView? = null;
    init {
        imageView = image_View;
    }

    override fun doInBackground(vararg params: String?): Bitmap? {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val uplink = params[0]
        var bitmap: Bitmap? = null
        try {
            val bitmapStream = URL(uplink).openStream()
            bitmap = BitmapFactory.decodeStream(bitmapStream)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return bitmap
    }

    override fun onPostExecute(bitmap: Bitmap?) { //super.onPostExecute(bitmap);
        imageView!!.setImageBitmap(bitmap)
    }
}