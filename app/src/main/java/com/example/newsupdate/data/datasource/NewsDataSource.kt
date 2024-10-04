package com.example.newsupdate.data.datasource

import com.example.newsapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(country : String) : Response<NewsResponse>
}