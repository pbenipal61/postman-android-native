package com.postmaninteractive.postman.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import android.util.Log;

import com.postmaninteractive.postman.Models.CustomLocale;
import com.postmaninteractive.postman.Models.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class AuthHelper {

    private static final String TAG = "AuthHelper";
    private static PostmanApi postmanApi;
    private static Retrofit retrofit;
    private static SharedPreferences sp;



    public static  void init(final Context context){


//        retrofit = RetroftHelper.generate("users");
//        postmanApi = retrofit.create(PostmanApi.class);
//
//       //TODO SECURE DATA SAVING AND RETRIEVAL
//       sp = context.getSharedPreferences("LOGIN_INFO", MODE_PRIVATE);
//       String defaultStr = "default";
//       String token = sp.getString("apiToken", defaultStr);
//       String id = sp.getString("id", defaultStr);
//       assert token != null;
//       if(token.equalsIgnoreCase(defaultStr) || id.equalsIgnoreCase(defaultStr)){
//
//           Log.d(TAG, "init: registering user...");
////           register(context);
//            register(context);
//
//       }else{
//
//           Log.d(TAG, "init: logging user in...");
//       }

    }

    private static String login(String username, String password, Context context){

        String apiToken = null;
        retrofit = RetroftHelper.generate("users");
        postmanApi = retrofit.create(PostmanApi.class);

        Call<LoginResponse> call = postmanApi.login(username, password);
        try {
            Response<LoginResponse> loginResponse = call.execute();


        } catch (IOException e) {
            e.printStackTrace();
        }

            return apiToken;
    }

    private static void register(Context context){

        Log.d(TAG, "register: Registering...");



        Call<CustomLocale> call = postmanApi.getCustomLocale();
        call.enqueue(new Callback<CustomLocale>() {
            @Override
            public void onResponse(Call<CustomLocale> call, Response<CustomLocale> response) {

                if(!response.isSuccessful()){
                    Log.d(TAG, "onResponse: response code" + response.code());
                    return;
                }

                CustomLocale customLocale = response.body();
                assert customLocale != null;
                Log.d(TAG, "onResponse: City is " + customLocale.getCity());


                User user = new User(
                        "Laura",
                        "Kortelainen",
                        "leelauraforever@gmail.com",
                        "Qwerty12",
                        "ENG",
                            customLocale.getCity(),
                            customLocale.getCountry(),
                        "Europe"
                );
                Call<RegisterResponse> call2 = postmanApi.register(
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getLanguage(),
                        user.getCity(),
                        user.getCountry(),
                        user.getContinent()
                );
                call2.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call2, Response<RegisterResponse> response) {
                        if(!response.isSuccessful()){
                            Log.d(TAG, "onResponse: User registeration failed "+ response.code()+" "+response.message());
                            return ;
                        }

                        RegisterResponse registerResponse = response.body();
                        Log.d(TAG, "onResponse: user registered " + registerResponse.getToken());
                        sp.edit().putString("apiToken", registerResponse.getToken()).apply();
                        sp.edit().putString("id", registerResponse.getId()).apply();





                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call2, Throwable t) {

                        Log.d(TAG, "onFailure: Failed to register" +  t.getMessage());

                    }
                });


            }

            @Override
            public void onFailure(Call<CustomLocale> call, Throwable t) {

                t.printStackTrace();

            }
        });




    }


    public class RegisterResponse{

        private String token, id;

        public RegisterResponse(String token, String id) {
            this.token = token;
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


    }

    public class LoginResponse{

        private User user;
        private String token;

        public LoginResponse(User user, String token) {
            this.user = user;
            this.token = token;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }


}
