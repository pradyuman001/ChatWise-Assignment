package com.example.chatwisedemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        private const val baseUrl = "https://jsonplaceholder.typicode.com/"


        fun getRetrofit(): Retrofit {

            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

    }

}