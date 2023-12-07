package com.gagan.newsapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.gagan.newsapp.data.database.model.NewsEntity
import com.gagan.newsapp.data.mapper.SavedMapper
import com.gagan.newsapp.data.mapper.SourceMapper
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.data.model.SourceModel
import com.gagan.newsapp.data.response.NewsResponse
import com.gagan.newsapp.data.response.SourceResponse
import com.gagan.newsapp.data.mapper.NewsMapper
import com.gagan.newsapp.utils.interfaces.Mapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    @Singleton
    abstract fun bindNewsMapper(mapper: NewsMapper): Mapper<NewsResponse, NewsModel>

    @Binds
    @Singleton
    abstract fun bindSourceMapper(mapper: SourceMapper): Mapper<SourceResponse, SourceModel>

    @Binds
    @Singleton
    abstract fun bindSavedNewsMapper(mapper: SavedMapper): Mapper<NewsModel, NewsEntity>

}