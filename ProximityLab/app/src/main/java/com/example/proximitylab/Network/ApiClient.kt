package com.example.proximitylab.Network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    public var BASE_URL: String = "https://api.imgflip.com/"
    public var retrofit: Retrofit? = null

    public fun getApiClient():Retrofit?{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }


}