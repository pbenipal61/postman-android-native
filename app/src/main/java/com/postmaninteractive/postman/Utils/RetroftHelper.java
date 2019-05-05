package com.postmaninteractive.postman.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroftHelper {

    public static Retrofit generate(String route){

        String baseUrl = "http://18.218.184.115:3000/"+route+"/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return  retrofit;
    }


}
