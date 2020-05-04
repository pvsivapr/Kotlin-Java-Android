package com.example.androidselflearningtutorials;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidselflearningtutorials.first_recycler_view.NewsListPage;
import com.sivaprasad.controls.DisplayAlert;

public class InitialLoadPage extends AppCompatActivity implements View.OnClickListener {

    DisplayAlert displayAlert ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_load_page);

        //Start Hides the default header
        // set theme for activity in manifest - and create a theme in styles.xml with id - NoDefaultHeaderAppTheme
        //End

        //Start To make a display alert
        displayAlert = new DisplayAlert (this);
        //End

        LoadViews();
    }

    private void LoadViews()
    {
        try {
            Button displayAlertButton = findViewById(R.id.display_alert_button);
            displayAlertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayAlert.ShowDisplayAlert("Alert", "Hello World this is a display alert", "OK");
                }
            });
        }catch (Exception ex)
        {
            String msg = ex.getMessage();
        }
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.enter_first_recyclerview_layout_button:
                    Intent firstRecyclerViewIntent = new Intent(this, NewsListPage.class);
                    startActivity(firstRecyclerViewIntent);
                    /*
                    Intent firstRecyclerViewIntent = new Intent();
                    firstRecyclerViewIntent.setComponent(new ComponentName("com.example.androidselflearningtutorials.first_recycler_view.NewsListPage", "com.example.androidselflearningtutorials.first_recycler_view.NewsListPage.NewsListPage.class"));
                    startActivity(firstRecyclerViewIntent);
                    */
                    break;
                case R.id.initial_load_back_button:
                    this.finish();
                    break;
                default:
                    break;
            }
        }
        catch (Exception ex)
        {
            Log.e(this.getLocalClassName(), ex.getMessage());
        }
    }
}
