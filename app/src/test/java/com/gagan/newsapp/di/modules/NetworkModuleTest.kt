package com.gagan.newsapp.di.modules

import org.junit.Assert

import org.junit.Test

class NetworkModuleTest {

    @Test
    fun provideHttpClient_NotNull() {
        val httpClient = NetworkModule.provideHttpClient()
        Assert.assertNotNull(httpClient)
    }

    @Test
    fun provideRetrofit_NotNull() {
        val httpClient = NetworkModule.provideHttpClient()
        val converterFactory = NetworkModule.provideConverterFactory()
        val retrofitClient = NetworkModule.provideRetrofit(httpClient, converterFactory)
        Assert.assertNotNull(retrofitClient)
    }

    @Test
    fun provideConverterFactory_NotNull() {
        val converterFactory = NetworkModule.provideConverterFactory()
        Assert.assertNotNull(converterFactory)
    }

    @Test
    fun provideAPI_NotNull() {
        val httpClient = NetworkModule.provideHttpClient()
        val converterFactory = NetworkModule.provideConverterFactory()
        val retrofitClient = NetworkModule.provideRetrofit(httpClient, converterFactory)
        val newsAPI = NetworkModule.provideAPI(retrofitClient)
        Assert.assertNotNull(newsAPI)
    }
}