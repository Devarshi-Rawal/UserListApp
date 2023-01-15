package com.example.userlistapp.networking

import com.example.userlistapp.models.UserList
import com.example.userlistapp.models.UserListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterfaces {

    @GET("/photos/")
    suspend fun getAllUsers(
        @Query("client_id") clientId: String
    ) : Response<List<UserListItem>>
}