package com.gagan.newsapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SourceResponse(

    @SerializedName("id")
    @Expose
    val id: String?,

    @SerializedName("name")
    @Expose
    val name: String?
)
