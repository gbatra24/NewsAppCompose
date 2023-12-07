package com.gagan.newsapp.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SourceResponse(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?
)