package com.dwsj.mvc.APIs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit=null;

    public static Retrofit getRetrofit(){
        Gson gson=new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(logging).build();
        retrofit=new Retrofit.Builder().baseUrl("http://localhost:8484/api/").addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();
        return retrofit;
    }
}
