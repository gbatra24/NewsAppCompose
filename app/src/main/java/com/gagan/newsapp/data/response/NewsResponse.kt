package com.gagan.newsapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NewsResponse(

    @SerializedName("author")
    @Expose
    val author: String?,

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("url")
    @Expose
    val url: String?,

    @SerializedName("urlToImage")
    @Expose
    val urlToImage: String?,

    @SerializedName("publishedAt")
    @Expose
    val publishedAt: String?,

    @SerializedName("content")
    @Expose
    val content: String?,

    @SerializedName("source")
    @Expose
    val source: SourceResponse?
)
