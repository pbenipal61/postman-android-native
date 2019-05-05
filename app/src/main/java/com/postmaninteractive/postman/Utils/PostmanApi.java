package com.postmaninteractive.postman.Utils;

import com.postmaninteractive.postman.Models.CustomLocale;
import com.postmaninteractive.postman.Models.EventEntry;
import com.postmaninteractive.postman.Models.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

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

    @FormUrlEncoded
    @POST ("login")
    Call<AuthHelper.LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("locale")
    Call<CustomLocale> getCustomLocale();

    @GET("events")
    Call<List<EventEntry>> getEvents();

    @FormUrlEncoded
    @POST("events")
    Call<EventEntry> postEvent(
            @Field("title") String title,
            @Field("type") String type,
            @Field("message") String message,
            @Field("instructions") String instructions,
            @Field("reach") String reach,
            @Field("day") int day,
            @Field("month") int month,
            @Field("year") int year,
            @Field("hour") int hour,
            @Field("minute") int minute,
            @Field("city") String city,
            @Field("country") String country,
            @Field("continent") String continent,
            @Field("bound") String bound,
            @Field("photos") String photos[],
            @Field("contactName") String contactName,
            @Field("contactPhone") String contactPhone,
            @Field("contactEmail") String contactEmail,
            @Field("address") String Address,
            @Field("by") String by

    );


}
