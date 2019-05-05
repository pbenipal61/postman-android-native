package com.postmaninteractive.postman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.postmaninteractive.postman.Utils.AuthHelper;
import com.postmaninteractive.postman.Utils.PostmanApi;
import com.postmaninteractive.postman.Utils.RetroftHelper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthActivity extends AppCompatActivity {
    private static final String TAG = "AuthActivity";
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("LOGIN_INFO", MODE_PRIVATE);

        if(sp.getString("apiToken", "default") != "default"){
            Intent intent = new Intent(AuthActivity.this, MainActivity.class);
            startActivity(intent);
            return;
        }
        setContentView(R.layout.activity_auth);


        final EditText usernameView = (EditText) findViewById(R.id.usernameView);
        final EditText passwordView = (EditText) findViewById(R.id.passwordView);
        final ProgressBar progressBarView = (ProgressBar) findViewById(R.id.progressBarView);
        progressBarView.setVisibility(View.GONE);

        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBarView.setVisibility(View.VISIBLE);
                String username = usernameView.getText().toString();
                String password = passwordView.getText().toString();

                LoginThread loginThread = new LoginThread();
                loginThread.execute(username, password);
            }
        });
    }


    public class LoginThread extends AsyncTask<String, Void, String> {
        private static final String TAG = "LoginThread";
        private Retrofit retrofit = null;
        private PostmanApi postmanApi = null;

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(s != null){

                findViewById(R.id.progressBarView).setVisibility(View.GONE);
                sp.edit().putString("apiToken", s).apply();
                Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                startActivity(intent);

            }

        }

        @Override
        protected String doInBackground(String... strings) {
            String username = strings[0];
            String password = strings[1];
            String apiToken = null;


            retrofit = RetroftHelper.generate("users");
            postmanApi = retrofit.create(PostmanApi.class);

            Call<AuthHelper.LoginResponse> call = postmanApi.login(username, password);
            try {
                Response<AuthHelper.LoginResponse> response = call.execute();
                if(response.body() != null){
                    AuthHelper.LoginResponse loginResponse = response.body();
                    apiToken = loginResponse.getToken();
                    Log.d(TAG, "doInBackground: "+ apiToken);
                }else{

                    Log.d(TAG, "doInBackground: User not found or incorrect password");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            catch(Exception e){
                Log.d(TAG, "doInBackground: Error in login process");
            }



            return apiToken;
        }
    }
}
