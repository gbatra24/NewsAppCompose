package com.gagan.newsapp.apiServices

import com.gagan.newsapp.utils.constants.Constants
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPITest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var newsAPI: NewsAPI

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        newsAPI = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsAPI::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun getHeadlineNews_isResultEmpty() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("{\"articles\":[],\"totalResults\":\"0\"}")
        mockWebServer.enqueue(mockResponse)

        val response = newsAPI.getHeadlineNews(Constants.API_TOKEN, Constants.EN)
        mockWebServer.takeRequest()

        Assert.assertEquals(true, response.articles.isEmpty())
    }
}