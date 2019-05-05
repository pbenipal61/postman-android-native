package com.postmaninteractive.postman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.postmaninteractive.postman.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupBottomNavigationView();

        progressBar = (ProgressBar) findViewById(R.id.progressBarView);
        final EditText nameView = (EditText) findViewById(R.id.nameView);
        EditText usernameView = (EditText) findViewById(R.id.usernameView);
        EditText emailView = (EditText) findViewById(R.id.emailView);
        EditText bioView = (EditText) findViewById(R.id.bioView);
        Button saveView = (Button) findViewById(R.id.saveView);
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicking" + nameView.getText());
            }
        });


    }

    /**
     * Setup bottom navigation view
     */
    private  void setupBottomNavigationView(){

        Log.d(TAG, "setupBottomNavigationView: Setting up bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.nav_bottom);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx, this);
    }
}
