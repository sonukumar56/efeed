package com.example.efeed;

import com.example.efeed.model.Model1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitSetup {
    @GET("repos/{owner}/{repo}/issues")
    Call<List<Model1>> getClosedIssues(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Query("state") String state
    );
}

