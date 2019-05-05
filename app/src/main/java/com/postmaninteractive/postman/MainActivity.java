package com.postmaninteractive.postman;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.postmaninteractive.postman.Adapters.EventsAdapter;
import com.postmaninteractive.postman.Models.EventEntry;
import com.postmaninteractive.postman.Utils.AuthHelper;
import com.postmaninteractive.postman.Utils.BottomNavigationViewHelper;
import com.postmaninteractive.postman.Utils.PostmanApi;
import com.postmaninteractive.postman.Utils.RetroftHelper;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupBottomNavigationView();
//        AuthHelper.init(this);

        LoadEventsThread loadEventsThread = new LoadEventsThread();
//        loadEventsThread.execute("default");
    }

    /**
     * Setup bottom navigation view
     */
    private  void setupBottomNavigationView(){

        Log.d(TAG, "setupBottomNavigationView: Setting up bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.nav_bottom);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx, this);
    }



    private class LoadEventsThread extends AsyncTask<String, Void, List<EventEntry>>{

        private static final String TAG = "LoadEventsThread";

        @Override
        protected void onPostExecute(List<EventEntry> eventEntries) {
            super.onPostExecute(eventEntries);
            RecyclerView eventsListView = (RecyclerView) findViewById(R.id.eventsListView);
            EventsAdapter eventsAdapter = new EventsAdapter(eventEntries);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            eventsListView.setLayoutManager(mLayoutManager);
            eventsListView.setItemAnimator(new DefaultItemAnimator());
            eventsListView.setAdapter(eventsAdapter);



        }

        @Override
        protected List<EventEntry> doInBackground(String... strings) {

            List<EventEntry> eventsList = null;
            Retrofit retrofit = RetroftHelper.generate("api");
            PostmanApi postmanApi = retrofit.create(PostmanApi.class);
            Call<List<EventEntry>> call = postmanApi.getEvents();
            try {
                Response<List<EventEntry>> response = call.execute();
                if(response.body() != null){
                    eventsList = response.body();
                    Log.d(TAG, "doInBackground: " + eventsList.size());

                }else{

                    Log.d(TAG, "doInBackground: Failed to fetch events");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            return eventsList;
        }
    }
}
