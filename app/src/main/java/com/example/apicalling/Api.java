package com.example.apicalling;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {
        String BASE_URL = "https://jsonplaceholder.typicode.com/";

        @GET("users/1/todos")
        Call<List<ToDo>> getTodos();
}
