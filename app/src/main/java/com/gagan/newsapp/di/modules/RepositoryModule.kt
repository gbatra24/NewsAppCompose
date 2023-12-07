package com.gagan.newsapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.gagan.newsapp.data.repository.NewsRepository
import com.gagan.newsapp.utils.interfaces.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(newsRepository: NewsRepository): Repository

}