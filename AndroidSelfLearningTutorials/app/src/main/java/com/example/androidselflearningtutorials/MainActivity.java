package com.example.androidselflearningtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity// implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void CallMenuActivity(View view)
    {
        Intent menuIntent = new Intent(this, InitialLoadPage.class);
        startActivity(menuIntent);
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.enter_menu_button:
//                CallMenuActivity();
//                break;
//            default:
//                break;
//        }
//    }
}
