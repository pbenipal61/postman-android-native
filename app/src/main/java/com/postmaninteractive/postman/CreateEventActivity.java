package com.postmaninteractive.postman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.postmaninteractive.postman.Fragments.CreateEventBoundFragment;
import com.postmaninteractive.postman.Fragments.CreateEventContactFragment;
import com.postmaninteractive.postman.Fragments.CreateEventWhatFragment;
import com.postmaninteractive.postman.Fragments.CreateEventWhenFragment;
import com.postmaninteractive.postman.Fragments.CreateEventWhereFragment;
import com.postmaninteractive.postman.Models.EventEntry;
import com.postmaninteractive.postman.Utils.BottomNavigationViewHelper;
import com.postmaninteractive.postman.Utils.PostmanApi;
import com.postmaninteractive.postman.Utils.RetroftHelper;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CreateEventActivity extends AppCompatActivity implements CreateEventWhereFragment.WhereFragmentListener, CreateEventWhatFragment.WhatFragmentListener, CreateEventWhenFragment.WhenFragmentListener, CreateEventBoundFragment.BoundFragmentListener, CreateEventContactFragment.ContactFragmentListener {
    private static final String TAG = "CreateEventActivity";
    private CalendarView calendarView;
    private TimePicker timeView;

    private Button boundsView, contactView, whatView, whenView, whereView;
    private CreateEventWhereFragment whereFragment;
    private CreateEventWhatFragment whatFragment;
    private CreateEventBoundFragment boundFragment;
    private CreateEventWhenFragment whenFragment;
    private CreateEventContactFragment contactFragment;
    private int dateArr[] = new int[3];
    private int timeArr[] = new int[2];
    private Retrofit retrofit;
    private PostmanApi postmanApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_2);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_action_bar);
        getSupportActionBar().setElevation(0);

        boundsView = (Button) findViewById(R.id.boundsView);
        contactView = (Button) findViewById(R.id.contactView);
        whatView = (Button) findViewById(R.id.whatView);
        whenView = (Button) findViewById(R.id.whenView);
        whereView = (Button) findViewById(R.id.whereView);

        boundsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(selectFragment(CreateEventParts.BOUND));
            }
        });

        contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(selectFragment(CreateEventParts.CONTACT));
            }
        });

        whatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(selectFragment(CreateEventParts.WHAT));
            }
        });

        whereView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(selectFragment(CreateEventParts.WHERE));
            }
        });

        whenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(selectFragment(CreateEventParts.WHEN));
            }
        });


        retrofit = RetroftHelper.generate("api");
        postmanApi = retrofit.create(PostmanApi.class);


        setupBottomNavigationView();
    }

    private enum CreateEventParts {
        BOUND, CONTACT, WHAT, WHEN, WHERE
    }

    private Fragment selectFragment(CreateEventParts part) {

        Fragment fragment = null;
        switch (part) {

            case BOUND:
                fragment = new CreateEventBoundFragment();
                break;

            case CONTACT:
                fragment = new CreateEventContactFragment();
                break;

            case WHAT:
                fragment = new CreateEventWhatFragment();
                break;

            case WHEN:
                fragment = new CreateEventWhenFragment();
                break;

            case WHERE:
                fragment = new CreateEventWhereFragment();
                break;
        }


        return fragment;


    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_create_event_top_bar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.ic_done:
                Log.d(TAG, "onOptionsItemSelected: done");
                postEvent();
                break;

            case R.id.ic_preview:
                Log.d(TAG, "onOptionsItemSelected: preview");
                break;
        }

        return true;
    }

    private void postEvent() {

        String[] photos = {"null"};
        Call<EventEntry> call = postmanApi.postEvent(
                "",
                "",
                "",
                "",
                "",
                dateArr[0], dateArr[1], dateArr[2],
                timeArr[1], timeArr[0],

                "", "",
                "Europe",
                "",
                photos,
                "",
                "",
                "",
                "",
                "leelaura"
        );


    }

    private void setupBottomNavigationView() {

        Log.d(TAG, "setupBottomNavigationView: Setting up bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.nav_bottom);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx, this);
    }

    @Override
    public void onWhereValuesSaved(String[] vals) {

        Log.d(TAG, "onWhereValuesSaved: " + vals[0]);
    }

    @Override
    public void onWhatValuesSaved(String[] vals) {
        Log.d(TAG, "onWhatValuesSaved: " + vals[0]);
    }

    @Override
    public void onWhenValuesChanges(int[] vals) {

    }

    @Override
    public void onBoundValuesSaved(String[] vals) {

    }

    @Override
    public void onContactValuesSaved(String[] vals) {

    }
}
