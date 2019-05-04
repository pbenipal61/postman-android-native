package com.postmaninteractive.postman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.postmaninteractive.postman.Utils.BottomNavigationViewHelper;

public class CreateEventActivity extends AppCompatActivity {
    private static final String TAG = "CreateEventActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        
        setupBottomNavigationView();
    }


    private  void setupBottomNavigationView(){

        Log.d(TAG, "setupBottomNavigationView: Setting up bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.nav_bottom);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx, this);
    }
}
