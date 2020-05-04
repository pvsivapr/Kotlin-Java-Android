package com.sivaprasad.controls;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class DisplayAlert {

    private AlertDialog.Builder alertDailogBuilder;

    public DisplayAlert(Context context) {
        alertDailogBuilder = new AlertDialog.Builder(context);
    }

    /*
    public static AlertDialog.Builder alertDailogBuilder;
    public static void ShowDisplayAlert(Context context, String title, String message, String dismissText)
    {
        try
        {
            alertDailogBuilder = new AlertDialog.Builder(context);
            alertDailogBuilder.setTitle(title);
            alertDailogBuilder.setMessage(message);
            alertDailogBuilder.setPositiveButton(dismissText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDailogBuilder.show();
        }
        catch (Exception ex){}
    }
    */
    public void ShowDisplayAlert(String title, String message, String dismissText) {
        try {
            alertDailogBuilder.setTitle(title);
            alertDailogBuilder.setMessage(message);
            alertDailogBuilder.setPositiveButton(dismissText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDailogBuilder.show();
        } catch (Exception ex) {
        }
    }
}
