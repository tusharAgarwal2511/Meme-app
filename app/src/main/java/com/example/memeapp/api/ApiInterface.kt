package com.example.memeapp.api

import com.example.memeapp.memeModal.MemeModal
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/gimme") // endpoint
    suspend fun getMemes() : Response<MemeModal>
}