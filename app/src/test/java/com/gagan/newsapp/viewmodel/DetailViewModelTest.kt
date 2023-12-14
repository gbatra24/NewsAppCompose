package com.gagan.newsapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gagan.newsapp.data.repository.NewsRepository
import com.gagan.newsapp.getOrAwaitValue
import com.nhaarman.mockitokotlin2.anyOrNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: NewsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_fetchIsBookmarked_forEmptyUrl() = runTest{
        Mockito.`when`(repository.isBookmarked(anyOrNull())).thenReturn(false)
        val vm = DetailViewModel(repository)

        vm.fetchIsBookmarked("")
        testDispatcher.scheduler.advanceUntilIdle()
        val result = vm.existNewsLiveData.getOrAwaitValue()
        Assert.assertEquals( false, result)

    }

//    @Test
//    fun test_fetchDeleteNews() = runTest {
//        val article = NewsModel("this is author", "this is title",
//            "this is description", "url", "this is image url",
//            "","Content",SourceModel("source id", "this is source"))
//
//        val vm = DetailViewModel(repository)
//        vm.fetchDeleteNews(article)
//        testDispatcher.scheduler.advanceUntilIdle()
//        val result = vm.fetchIsBookmarked(article.url)
//        Assert.assertEquals(false, result)
//
//    }
//
//    @Test
//    fun test_fetchSaveNews() {
//        val article = NewsModel("this is author", "this is title",
//            "this is description", "url", "this is image url",
//            "","Content",SourceModel("source id","this is source"))
//
//        val vm = DetailViewModel(repository)
//        vm.fetchSaveNews(article)
//        testDispatcher.scheduler.advanceUntilIdle()
//
//        var result = vm.fetchIsBookmarked(article.url)
//        Assert.assertEquals(true, result)
//
//        result = vm.fetchIsBookmarked("")
//        Assert.assertEquals(false, result)
//    }
}
