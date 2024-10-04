package com.example.newsupdate.data.datasource

import com.example.newsapp.data.entity.NewsResponse
import com.example.newsupdate.data.AppConstants
import com.example.newsupdate.data.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(private val apiService: ApiService) : NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(AppConstants.COUNTRY, AppConstants.API_KEY)
    }
}