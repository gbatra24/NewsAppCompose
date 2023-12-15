package com.gagan.newsapp.data.database.table

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.gagan.newsapp.data.database.dao.SavedNewsDao
import com.gagan.newsapp.data.database.model.NewsEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SavedNewsDatabaseTest {

    private lateinit var newsDao: SavedNewsDao
    private lateinit var newsDatabase: SavedNewsDatabase

    @Before
    fun setUp(){
        newsDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SavedNewsDatabase::class.java
        ).allowMainThreadQueries().build()

        newsDao = newsDatabase.savedNewsDao()
    }

    @After
    fun tearDown() {
        newsDatabase.close()
    }

    @Test
    fun writeAndReadNewsArticle() = runBlocking {
        val article = NewsEntity("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content","","this is source")
        newsDao.insertNews(article)

        val result = newsDao.getAllNews()

        Assert.assertEquals(1, result.size)
    }

}