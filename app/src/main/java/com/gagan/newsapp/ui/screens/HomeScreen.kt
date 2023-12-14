package com.gagan.newsapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.gagan.newsapp.R
import com.gagan.newsapp.ui.component.ItemNews
import com.gagan.newsapp.ui.component.ShimmerHomeScreen
import com.gagan.newsapp.ui.component.ToolbarHome
import com.gagan.newsapp.ui.component.ViewError
import com.gagan.newsapp.ui.theme.LightGrey
import com.gagan.newsapp.viewmodel.NewsViewModel

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    navController: NavController,
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val headlineNews by newsViewModel.headlineNewsLiveData.observeAsState(listOf())
    val error by newsViewModel.errorLiveData.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(LightGrey),
    ) {
        ToolbarHome(navController)

        if (error) {
            ViewError(tryAgainClick = { newsViewModel.tryAgain() })
        } else {
            if (headlineNews.isEmpty()) {
                ShimmerHomeScreen()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(LightGrey),
                    contentPadding = PaddingValues(bottom = dimensionResource(id = R.dimen.dim_20dp),
                        top = dimensionResource(id = R.dimen.dim_8dp))
                ) {

                    if (headlineNews.isNotEmpty()) {
                        for (i in headlineNews.indices) {
                            item {
                                ItemNews(
                                    navController = navController,
                                    news = headlineNews[i]
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
