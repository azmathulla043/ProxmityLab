package com.example.proximitylab.Network

import com.example.proximitylab.Model.Data
import retrofit2.http.GET

interface ApiInterface {
    @GET("get_memes")
    suspend fun fetchMems(): Data
}