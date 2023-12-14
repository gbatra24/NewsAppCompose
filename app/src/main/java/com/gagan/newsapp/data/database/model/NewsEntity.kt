package com.gagan.newsapp.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gagan.newsapp.utils.constants.Constants.SAVED_NEWS_TABLE

@Entity(tableName = SAVED_NEWS_TABLE)
data class NewsEntity(

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "url")
    @PrimaryKey(autoGenerate = false)
    val url: String,

    @ColumnInfo(name = "urlToImage")
    val urlToImage: String,

    @ColumnInfo(name = "published_at")
    val publishedAt: String,

    @ColumnInfo(name = "content")
    val content: String,

    @ColumnInfo(name = "source_id")
    val sourceId: String,

    @ColumnInfo(name = "source_name")
    val sourceName: String
)
