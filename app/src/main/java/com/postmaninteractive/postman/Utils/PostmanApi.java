package com.postmaninteractive.postman.Utils;

import com.postmaninteractive.postman.Models.CustomLocale;
import com.postmaninteractive.postman.Models.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostmanApi {

    @FormUrlEncoded
    @POST("register")
    Call<AuthHelper.RegisterResponse> register(
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("email") String email,
            @Field("password") String password,
            @Field("language") String language,
            @Field("city") String city,
            @Field("country") String country,
            @Field("continent") String continent
    );

    @POST ("login")
    Call<AuthHelper.LoginResponse> login(

    );

    @GET("locale")
    Call<CustomLocale> getCustomLocale();

}
