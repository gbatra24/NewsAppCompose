package com.gagan.newsapp.data.mapper

import com.gagan.newsapp.utils.interfaces.Mapper
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.model.SourceModel
import com.gagan.newsapp.data.response.NewsResponse
import com.gagan.newsapp.data.response.SourceResponse
import com.gagan.newsapp.utils.constants.Constants
import javax.inject.Inject


class NewsMapper @Inject constructor() : Mapper<NewsResponse, NewsModel> {

    override fun mapResponseToModel(response: NewsResponse): NewsModel {
        val sourceModel = if (response.source?.id != null && response.source.name != null) {
            SourceModel(response.source.id, response.source.name)
        } else {
            SourceModel(Constants.EMPTY, Constants.EMPTY)
        }

        return NewsModel(
            author = response.author ?: Constants.EMPTY,
            title = response.title ?: Constants.EMPTY,
            description = response.description ?: Constants.EMPTY,
            content = response.content ?: Constants.EMPTY,
            url = response.url ?: Constants.EMPTY,
            urlToImage = response.urlToImage ?: Constants.EMPTY,
            publishedAt = response.publishedAt ?: Constants.EMPTY,
            sourceModel = sourceModel
        )
    }

    override fun mapModelToResponse(model: NewsModel): NewsResponse {
        val sourceResponse = SourceResponse(model.sourceModel?.id,model.sourceModel?.name)

        return NewsResponse(
            author = model.author,
            title = model.title,
            description = model.description,
            content = model.content,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            source = sourceResponse
        )
    }

}
