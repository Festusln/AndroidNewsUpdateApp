package com.example.newsapp.data.entity

data class Article(
    val author: String?,
    val title: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val url: String?,
    val urlToImage: String?
)