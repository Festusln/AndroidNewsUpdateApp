package com.example.newsupdate.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newsapp.data.entity.NewsResponse
import com.example.newsupdate.ui.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {
    suspend fun getNewsHeadline(country : String) : Response<NewsResponse> {
        return newsRepository.getNewsHeadline(country)
    }
}