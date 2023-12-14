package com.gagan.newsapp.utils.interfaces

import com.gagan.newsapp.data.model.NewsModel

interface Repository {

    suspend fun getHeadlineNews(): List<NewsModel>

    suspend fun getSavedNews(): List<NewsModel>

    suspend fun insertSavedNews(news: NewsModel)

    suspend fun deleteNews(news: NewsModel)

    suspend fun isBookmarked(url: String): Boolean

}
