package com.postmaninteractive.postman.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.postmaninteractive.postman.Models.User;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class AuthHelper {

    private static final String TAG = "AuthHelper";
    private static PostmanApi postmanApi;
    private static Retrofit retrofit;

    public static  void init(final Context context){


        retrofit = RetroftHelper.generate("users");
        postmanApi = retrofit.create(PostmanApi.class);

       //TODO SECURE DATA SAVING AND RETRIEVAL
       SharedPreferences sp = context.getSharedPreferences("LOGIN_INFO", MODE_PRIVATE);
       String defaultStr = "default";
       String token = sp.getString("apiToken", defaultStr);

       assert token != null;
       if(token.equalsIgnoreCase(defaultStr)){

           Log.d(TAG, "init: getting apiToken...");
//           register(context);

           LocationHelper.init(context);

       }

    }

    private static void register(Context context){

        Log.d(TAG, "register: Registering...");




        User user = new User("Laura", "Kortelainen", "leelauraforever@gmail.com", "Qwerty12", "ENG", "Oulu", "Finland", "Europe");
        Call<User> call = postmanApi.register(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getLanguage(),
                user.getCity(),
                user.getCountry(),
                user.getContinent()
        );
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Log.d(TAG, "onResponse: User registeration failed "+ response.code()+" "+response.message());
                    return ;
                }

                User userResponse = response.body();
                Log.d(TAG, "onResponse: user registered " + response);




            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.d(TAG, "onFailure: Failed to register" +  t.getMessage());

            }
        });


    }
}
