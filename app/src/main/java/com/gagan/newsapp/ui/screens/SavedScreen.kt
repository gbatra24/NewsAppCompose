package com.gagan.newsapp.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.gagan.newsapp.ui.component.ItemSavedNews
import com.gagan.newsapp.ui.component.ToolbarSaved
import com.gagan.newsapp.ui.component.ViewEmpty
import com.gagan.newsapp.ui.theme.LightGrey
import com.gagan.newsapp.viewmodel.SavedViewModel
import com.gagan.newsapp.R

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun SavedScreen(
    navController: NavController,
    name: String?,
    savedViewModel: SavedViewModel = hiltViewModel()
) {
    val savedNews by savedViewModel.savedNewsLiveData.observeAsState(listOf())

    savedViewModel.fetchSavedNews()

    Column(
        modifier = Modifier
            .background(LightGrey)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ToolbarSaved(navController = navController)

        if (savedNews.isEmpty())
            ViewEmpty()
        else
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(LightGrey),
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(dimensionResource(id = R.dimen.dim_8dp))
            ) {
                savedNews.map {
                    item {
                        ItemSavedNews(
                            news = it,
                            navController = navController
                        )
                    }
                }
            }
    }
}