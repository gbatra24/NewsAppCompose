package com.gagan.newsapp.data.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import com.gagan.newsapp.apiServices.NewsAPI
import com.gagan.newsapp.data.database.dao.SavedNewsDao
import com.gagan.newsapp.data.mapper.NewsMapper
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.mapper.SavedMapper
import com.gagan.newsapp.utils.interfaces.Repository
import javax.inject.Inject

@ActivityRetainedScoped
class NewsRepository @Inject constructor(
    private val newsAPI: NewsAPI,
    private val savedNewsDao: SavedNewsDao,
    private val mapper: NewsMapper,
    private val savedNewsMapper: SavedMapper
) : Repository {

    override suspend fun getHeadlineNews(): List<NewsModel> {
        return newsAPI.getHeadlineNews().articles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

    override suspend fun getSavedNews(): List<NewsModel> {
        return savedNewsDao.getAllNews().map {
            savedNewsMapper.mapModelToResponse(
                it
            )
        }
    }

    override suspend fun insertSavedNews(news: NewsModel) {
        savedNewsDao.insertNews(savedNewsMapper.mapResponseToModel(news))
    }

    override suspend fun deleteNews(news: NewsModel) {
        savedNewsDao.deleteNews(savedNewsMapper.mapResponseToModel(news))
    }

    override suspend fun isBookmarked(url: String) : Boolean {
        return savedNewsDao.isBookmarked(url)
    }

}
