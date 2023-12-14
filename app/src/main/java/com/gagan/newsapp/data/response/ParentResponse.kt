package com.gagan.newsapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ParentResponse(

    @SerializedName("articles")
    @Expose
    val articles: List<NewsResponse>,

    @SerializedName("totalResults")
    @Expose
    val totalResults: Int
)
