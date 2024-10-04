package com.example.newsupdate.ui.repository

import com.example.newsapp.data.entity.NewsResponse
import com.example.newsupdate.data.datasource.NewsDataSource
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getNewsHeadline(country : String) : Response<NewsResponse> {
        return newsDataSource.getNewsHeadline(country)
    }
}
