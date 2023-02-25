package com.ipac.myipac.pagination;

import com.ipac.myipac.db.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("api/")
    Call<UserResponse> getUsers(
            @Query("results") int page
    );
}
