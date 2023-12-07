package com.gagan.newsapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gagan.newsapp.data.database.dao.SavedNewsDao
import com.gagan.newsapp.data.database.model.NewsEntity
import com.gagan.newsapp.data.database.table.SavedNewsDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SavedNewsDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var newsDao: SavedNewsDao
    lateinit var newsDatabase: SavedNewsDatabase

    @Before
    fun setUp(){
        newsDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SavedNewsDatabase::class.java
        ).allowMainThreadQueries().build()

        newsDao = newsDatabase.savedNewsDao()
    }

    @Test
    fun saveNews_expectedSingleNews() = runBlocking {
        val article = NewsEntity("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content","","this is source")
        newsDao.insertNews(article)

        val result = newsDao.getAllNews()

        Assert.assertEquals(1, result.size)
        Assert.assertEquals("this is image url", result[0].urlToImage)
    }

    @Test
    fun deleteNews_expectedNoResult() = runBlocking {
        val article = NewsEntity("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content","","this is source")
        newsDao.insertNews(article)
        newsDao.deleteNews(article);

        val result = newsDao.getAllNews()

        Assert.assertEquals(0, result.size)
    }

    @Test
    fun getIsBookmarked_expectedTrue() = runBlocking {
        val article = NewsEntity("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content","","this is source")
        newsDao.insertNews(article)

        val result = newsDao.isBookmarked("url")

        Assert.assertEquals(true, result)
    }

    @Test
    fun getIsBookmarked_expectedFalseIfUrlEmpty() = runBlocking {
        val article = NewsEntity("this is author", "this is title",
            "this is description", "url", "this is image url",
            "","Content","","this is source")
        newsDao.insertNews(article)

        val result = newsDao.isBookmarked("")

        Assert.assertEquals(false, result)
    }

    @After
    fun tearDown() {
        newsDatabase.close()
    }
}