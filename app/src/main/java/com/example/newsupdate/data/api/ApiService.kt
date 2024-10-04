package com.example.newsupdate.data.api

import com.example.newsapp.data.entity.NewsResponse
import com.example.newsupdate.data.AppConstants
import retrofit2.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String = AppConstants.API_KEY
    ) : Response<NewsResponse>

    //GET https://newsapi.org/v2/top-headlines?country=us&apiKey=cf12f99a0bbe43e89cec023bef51a69a
}