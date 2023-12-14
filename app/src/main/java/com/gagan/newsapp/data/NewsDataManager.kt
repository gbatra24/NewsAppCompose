package com.gagan.newsapp.data

import com.gagan.newsapp.data.model.NewsModel

object NewsDataManager {
    var news: List<NewsModel> = emptyList()

    fun getArticle(title: String) : NewsModel{
        lateinit var newsModel:NewsModel
        for(model in news) {
            if (model.title.contains(title)) {
                newsModel = model
            }
        }
        return newsModel
    }
}
