package com.gagan.newsapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gagan.newsapp.data.repository.NewsRepository
import com.gagan.newsapp.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SavedViewModelTest {

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
    fun test_fetchSavedNews() = runTest {
        Mockito.`when`(repository.getSavedNews()).thenReturn(emptyList())

        val vm = SavedViewModel(repository)
        vm.fetchSavedNews()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = vm.savedNewsLiveData.getOrAwaitValue()
        Assert.assertEquals( 0, result.size)
    }
}