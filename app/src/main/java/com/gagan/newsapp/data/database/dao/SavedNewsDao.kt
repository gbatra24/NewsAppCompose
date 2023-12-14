package com.gagan.newsapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gagan.newsapp.data.database.model.NewsEntity
import com.gagan.newsapp.utils.constants.Constants.SAVED_NEWS_TABLE

@Dao
interface SavedNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: NewsEntity)

    @Delete
    suspend fun deleteNews(news: NewsEntity)

    @Query("SELECT * FROM $SAVED_NEWS_TABLE")
    suspend fun getAllNews(): List<NewsEntity>

    @Query("SELECT EXISTS (SELECT 1 FROM $SAVED_NEWS_TABLE WHERE url = :url)")
    suspend fun isBookmarked(url: String): Boolean

}
