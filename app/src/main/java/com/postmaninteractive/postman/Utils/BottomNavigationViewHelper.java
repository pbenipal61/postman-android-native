package com.postmaninteractive.postman.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.postmaninteractive.postman.MainActivity;
import com.postmaninteractive.postman.ProfileActivity;
import com.postmaninteractive.postman.R;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx, final Context context){

        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

        enableNavigation(bottomNavigationViewEx, context);
    }


    private static void enableNavigation(BottomNavigationViewEx bottomNavigationViewEx, final Context context){

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Intent intent = null;
                switch(menuItem.getItemId()){
                    case R.id.ic_home:
                        intent = new Intent(context, MainActivity.class);
                        break;

                    case R.id.ic_profile:
                        intent = new Intent(context, ProfileActivity.class);
                        break;
                }

                if(intent != null){

                    context.startActivity(intent);
                }
                return false;
            }
        });
    }
}
