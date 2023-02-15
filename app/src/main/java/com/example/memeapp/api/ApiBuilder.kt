package com.example.memeapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    // base url of the api
    private const val BASE_URL = "https://meme-api.com/gimme/"

    fun getInstance(): Retrofit {

        return Retrofit.Builder()

            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}