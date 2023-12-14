package com.gagan.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.gagan.newsapp.base.BaseViewModel
import com.gagan.newsapp.data.NewsDataManager
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.repository.NewsRepository
import com.gagan.newsapp.utils.constants.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : BaseViewModel() {

    init {
        fetchHeadlineNews()
    }

    private val headlineNews = MutableLiveData<List<NewsModel>>()
    val headlineNewsLiveData: LiveData<List<NewsModel>>
        get() = headlineNews

    fun fetchHeadlineNews() = viewModelScope.launch(exceptionHandler) {
        delay(Constants.API_TIMEOUT.toLong())
        headlineNews.value = (repository.getHeadlineNews())
        NewsDataManager.news = repository.getHeadlineNews()
    }

    fun tryAgain() {
        error.value = false
        fetchHeadlineNews()
    }

}
