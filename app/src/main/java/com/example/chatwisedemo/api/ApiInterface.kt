package com.example.chatwisedemo.api

import com.example.chatwisedemo.model.ChatWiseModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")

    suspend fun getData(): Response<List<ChatWiseModelItem>>
}