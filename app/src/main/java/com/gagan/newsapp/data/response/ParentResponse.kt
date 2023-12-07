package com.gagan.newsapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ParentResponse(
    @Json(name = "articles")
    val articles: List<NewsResponse>,
    @Json(name = "totalResults")
    val totalResults: Int
)