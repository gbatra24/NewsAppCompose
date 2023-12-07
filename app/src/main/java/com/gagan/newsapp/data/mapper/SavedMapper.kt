package com.gagan.newsapp.data.mapper

import com.gagan.newsapp.data.database.model.NewsEntity
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.model.SourceModel
import com.gagan.newsapp.utils.constants.Constants
import com.gagan.newsapp.utils.interfaces.Mapper
import javax.inject.Inject

class SavedMapper @Inject constructor() : Mapper<NewsModel, NewsEntity> {

    override fun mapResponseToModel(response: NewsModel): NewsEntity {
        return NewsEntity(
            author = response.author,
            title = response.title,
            description = response.description,
            content = response.content,
            url = response.url,
            urlToImage = response.urlToImage,
            publishedAt = response.publishedAt,
            sourceId = response.sourceModel?.id ?: Constants.EMPTY,
            sourceName = response.sourceModel?.name ?: Constants.EMPTY,
        )
    }

    override fun mapModelToResponse(model: NewsEntity): NewsModel {
        return NewsModel(
            author = model.author,
            title = model.title,
            description = model.description,
            content = model.content,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            sourceModel = SourceModel(id = model.sourceId, name = model.sourceName)
        )
    }

}