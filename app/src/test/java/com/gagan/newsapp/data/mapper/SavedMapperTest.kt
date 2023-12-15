package com.gagan.newsapp.data.mapper

import com.gagan.newsapp.data.database.model.NewsEntity
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.model.SourceModel
import org.junit.Assert
import org.junit.Test

class SavedMapperTest {

    private val savedMapper = SavedMapper()

    @Test
    fun mapResponseToModel_isNotNull() {
        val articleModel = NewsModel("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content", SourceModel("","this is source"))

        val newsEntity = savedMapper.mapResponseToModel(articleModel)
        Assert.assertNotNull(newsEntity)
    }

    @Test
    fun mapModelToResponse_isNotNull() {
        val articleEntity = NewsEntity("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content", "","this is source")

        val articleModel = savedMapper.mapModelToResponse(articleEntity)
        Assert.assertNotNull(articleModel)
    }
}