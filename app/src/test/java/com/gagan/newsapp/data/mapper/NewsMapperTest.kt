package com.gagan.newsapp.data.mapper

import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.model.SourceModel
import com.gagan.newsapp.data.response.NewsResponse
import com.gagan.newsapp.data.response.SourceResponse
import org.junit.Assert
import org.junit.Test

class NewsMapperTest {

    private val newsMapper = NewsMapper()


    @Test
    fun mapResponseToModel_isNotNull() {
        val articleResponse = NewsResponse("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content", SourceResponse("","this is source"))

        val articleModel = newsMapper.mapResponseToModel(articleResponse)
        Assert.assertNotNull(articleModel)

    }

    @Test
    fun mapResponseToModel_isNotNull2() {
        val articleResponse = NewsResponse("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content", null)

        val articleModel = newsMapper.mapResponseToModel(articleResponse)
        Assert.assertNotNull(articleModel)

    }

    @Test
    fun mapModelToResponse() {
        val articleModel = NewsModel("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content", SourceModel("","this is source")
        )

        val articleResponse = newsMapper.mapModelToResponse(articleModel)
        Assert.assertNotNull(articleResponse)
    }
}