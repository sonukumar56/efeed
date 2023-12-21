package com.example.efeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.efeed.adapter.UserAdapter;
import com.example.efeed.model.Model1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private RetrofitSetup gitHubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubService = retrofit.create(RetrofitSetup.class);

        fetchClosedIssues();
    }

    private void fetchClosedIssues() {
        Call<List<Model1>> call = gitHubService.getClosedIssues("PriyanshuArora2001", "HackerRank-Solutions ", "closed");
        call.enqueue(new Callback<List<Model1>>() {
            @Override
            public void onResponse(Call<List<Model1>> call, Response<List<Model1>> response) {
                if (response.isSuccessful()) {
                    List<Model1> issues = response.body();
                    setupRecyclerView(issues);
                } else {
                    Toast.makeText(MainActivity.this, "somethin wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Model1>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"failure",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRecyclerView(List<Model1> issues) {
        userAdapter = new UserAdapter(issues);
        recyclerView.setAdapter(userAdapter);
    }
}
