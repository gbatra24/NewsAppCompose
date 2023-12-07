package com.gagan.newsapp.data.mapper

import com.gagan.newsapp.utils.interfaces.Mapper
import com.gagan.newsapp.data.model.SourceModel
import com.gagan.newsapp.data.response.SourceResponse
import com.gagan.newsapp.utils.constants.Constants
import javax.inject.Inject

class SourceMapper @Inject constructor() : Mapper<SourceResponse, SourceModel> {

    override fun mapResponseToModel(response: SourceResponse): SourceModel {
        return SourceModel(
            id = response.id ?: Constants.EMPTY,
            name = response.name ?: Constants.EMPTY
        )
    }

    override fun mapModelToResponse(model: SourceModel): SourceResponse {
        return SourceResponse(
            id = model.id,
            name = model.name
        )
    }

}