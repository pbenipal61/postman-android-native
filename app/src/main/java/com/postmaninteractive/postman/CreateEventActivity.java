package com.postmaninteractive.postman;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.postmaninteractive.postman.Models.EventEntry;
import com.postmaninteractive.postman.Utils.BottomNavigationViewHelper;
import com.postmaninteractive.postman.Utils.PostmanApi;
import com.postmaninteractive.postman.Utils.RetroftHelper;

import java.sql.Array;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CreateEventActivity extends AppCompatActivity {
    private static final String TAG = "CreateEventActivity";
    private CalendarView calendarView;
    private TimePicker timeView;
    private Spinner typeView, reachView, boundView;
    private EditText titleView, messageView, instructionsView, contactNameView, contactPhoneView, contactEmailView, addressView, cityView, countryView;
    private int dateArr[] = new int[3];
    private int timeArr[] = new int[2];
    private Retrofit retrofit;
    private PostmanApi postmanApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.layout_action_bar);
        getSupportActionBar().setElevation(0);

        retrofit = RetroftHelper.generate("api");
        postmanApi = retrofit.create(PostmanApi.class);

        typeView = findViewById(R.id.typeView);
        String[] types = { "Sports", "Food and Dining", };
        typeView.setAdapter(getArrayAdapter(types));


        reachView = findViewById(R.id.reachView);
        String[] reaches = {"Within city", "Country wide", "Global", "Online"};
        reachView.setAdapter(getArrayAdapter(reaches));

        boundView = findViewById(R.id.boundView);
        String[] bounds = {"Private", "Public"};
        boundView.setAdapter(getArrayAdapter(bounds));

        calendarView = (CalendarView) findViewById(R.id.calendarView);

        Log.d(TAG, "onCreate: "+ calendarView.getDate());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month,
                                            int date) {

                dateArr[0] = date;
                dateArr[1] = month;
                dateArr[2] = year;

            }
        });

        timeView = (TimePicker) findViewById(R.id.timeView);
        timeView.setIs24HourView(true);
        timeView.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                timeArr[0] = minute;
                timeArr[1] = hourOfDay;
            }
        });

        titleView = (EditText) findViewById(R.id.titleView);
        messageView = (EditText) findViewById(R.id.messageView);
        instructionsView = (EditText) findViewById(R.id.instructionsView);
        contactNameView = (EditText) findViewById(R.id.contactNameView);
        contactPhoneView = (EditText) findViewById(R.id.contactPhoneView);
        contactEmailView = (EditText) findViewById(R.id.contactEmailView);
        addressView = (EditText) findViewById(R.id.addressView);
        cityView = (EditText) findViewById(R.id.cityView);
        countryView = (EditText) findViewById(R.id.countryView);



        setupBottomNavigationView();
    }

    private ArrayAdapter<String> getArrayAdapter(String[] options){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_create_event_top_bar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id){

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

    private void postEvent(){

        String[] photos = {"null"};
        Call<EventEntry> call = postmanApi.postEvent(
                titleView.getText().toString(),
                typeView.getSelectedItem().toString(),
                messageView.getText().toString(),
                instructionsView.getText().toString(),
                reachView.getSelectedItem().toString(),
                dateArr[0], dateArr[1], dateArr[2],
                timeArr[1], timeArr[0],
                cityView.getText().toString(),
                countryView.getText().toString(),
                "Europe",
                boundView.getSelectedItem().toString(),
                photos,
                contactNameView.getText().toString(),
                contactPhoneView.getText().toString(),
                contactEmailView.getText().toString(),
                addressView.getText().toString(),
                "leelaura"
                );


    }

    private  void setupBottomNavigationView(){

        Log.d(TAG, "setupBottomNavigationView: Setting up bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.nav_bottom);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx, this);
    }
}
