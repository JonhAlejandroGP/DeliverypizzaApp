package com.example.loginsprint1.retrofit.Interfase;


import com.example.loginsprint1.retrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

    public interface JsonPlaceHolderApi {

        @GET("api/buscarTodo")
        Call<List<Posts>> getPosts();
    }

