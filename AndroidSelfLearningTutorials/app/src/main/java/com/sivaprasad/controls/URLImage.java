package com.sivaprasad.controls;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

public class URLImage extends AsyncTask<String, Void, Bitmap>
{
    ImageView imageView;
    public URLImage(ImageView _imageView)
    {
        this.imageView = _imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {

                /*
                URL url = new URL(newsListModel.getImage());
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                holder.newsItemDisplayImage.setImageBitmap(bmp);
                */
        String uplink = strings[0];
        Bitmap bitmap = null;
        try
        {
            InputStream bitmapStream = new java.net.URL(uplink).openStream();
            bitmap = BitmapFactory.decodeStream(bitmapStream);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        //super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }



    /*
    private Bitmap hhh()
    {
        try {
            Bitmap bitmap=null;
            URL imageUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)imageUrl.openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStream is=conn.getInputStream();
            OutputStream os = new FileOutputStream(f);
            Utils.CopyStream(is, os);
            os.close();
            bitmap = decodeFile(f);
            return bitmap;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    private Bitmap decodeFile(File f) {
        try {
//decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
//Find the correct scale value. It should be the power of 2.
            final int REQUIRED_SIZE = 70;
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE)
                    break;
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }
            //decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize=scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {}
        return null;
    }
    */
}