package com.gagan.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gagan.newsapp.base.BaseViewModel
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: NewsRepository
) : BaseViewModel() {

    private val existNews = MutableLiveData<Boolean>()
    val existNewsLiveData: LiveData<Boolean>
        get() = existNews

    fun fetchIsBookmarked(url: String) = viewModelScope.launch(exceptionHandler) {
        existNews.value = (repository.isBookmarked(url))
    }

    fun fetchDeleteNews(news: NewsModel) = viewModelScope.launch(exceptionHandler) {
        repository.deleteNews(news)
        fetchIsBookmarked(news.url)
    }

    fun fetchSaveNews(news: NewsModel) = viewModelScope.launch(exceptionHandler) {
        repository.insertSavedNews(news)
        fetchIsBookmarked(news.url)
    }

}
