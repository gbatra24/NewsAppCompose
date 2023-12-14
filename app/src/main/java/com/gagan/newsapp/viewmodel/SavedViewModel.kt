package com.gagan.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.gagan.newsapp.base.BaseViewModel
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val repository: NewsRepository
) : BaseViewModel() {

    private val savedNews = MutableLiveData<List<NewsModel>>()
    val savedNewsLiveData: LiveData<List<NewsModel>>
        get() = savedNews

    fun fetchSavedNews() = viewModelScope.launch(exceptionHandler) {
        savedNews.postValue(repository.getSavedNews())
    }

}
