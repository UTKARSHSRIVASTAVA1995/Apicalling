package com.example.apicalling;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView recyclerView;
    private ArrayList<ToDo> toDoArrayList;
    private DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        toDoArrayList = new ArrayList<>();
        Log.d("init","init called");
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api request = retrofit.create(Api.class);
        Log.d("load","loadjson called");
        Call<List<ToDo>> call = request.getTodos();
        call.enqueue(new Callback<List<ToDo>>() {

            @Override
            public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                List<ToDo> jsonResponse = response.body();
                toDoArrayList.addAll(jsonResponse);
                adapter = new DataAdapter(toDoArrayList);
                recyclerView.setAdapter(adapter);
                Log.d("response123",jsonResponse.toString());
            }

            @Override
            public void onFailure(Call<List<ToDo>> call, Throwable t) {
                Log.d("Error123", t.getMessage());

            }
        });
    }
}

