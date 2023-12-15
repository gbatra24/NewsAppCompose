package com.gagan.newsapp.data.mapper

import com.gagan.newsapp.data.model.SourceModel
import com.gagan.newsapp.data.response.SourceResponse
import org.junit.Assert
import org.junit.Test

class SourceMapperTest {

    private val sourceMapper = SourceMapper()

    @Test
    fun mapResponseToModel_isNotNull() {
        val sourceResponse = SourceResponse("id", "name")
        val sourceModel = sourceMapper.mapResponseToModel(sourceResponse)
        Assert.assertNotNull(sourceModel)
    }

    @Test
    fun mapModelToResponse_isNotNull() {
        val sourceModel = SourceModel("id", "name")
        val sourceResponse = sourceMapper.mapModelToResponse(sourceModel)
        Assert.assertNotNull(sourceResponse)
    }
}