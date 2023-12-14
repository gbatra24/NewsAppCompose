package com.gagan.newsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.gagan.newsapp.R
import com.gagan.newsapp.data.NewsDataManager
import com.gagan.newsapp.ui.component.ToolbarDetail
import com.gagan.newsapp.ui.theme.Grey
import com.gagan.newsapp.ui.theme.MediumGrey
import com.gagan.newsapp.utils.constants.Constants
import com.gagan.newsapp.utils.extentions.removeExtraChars
import com.gagan.newsapp.utils.intents.IntentHandler
import com.gagan.newsapp.utils.library.paintImage
import com.gagan.newsapp.viewmodel.DetailViewModel

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun DetailScreen(
    navController: NavController,
    name: String?,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val existNews by detailViewModel.existNewsLiveData.observeAsState(false)
    val news = name?.let { NewsDataManager.getArticle(it) }

    detailViewModel.fetchIsBookmarked(news?.url.orEmpty())

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ToolbarDetail(
            navController = navController,
            url = news?.url.orEmpty()
        )

        Image(
            painter = paintImage(image = news?.urlToImage.orEmpty()),
            contentDescription = Constants.EMPTY,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dim_300dp))
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dim_0_5dp))
                .background(MediumGrey)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dim_40dp))
                .background(Color.White)
                .padding(start = dimensionResource(id = R.dimen.dim_16dp),
                    end = dimensionResource(id = R.dimen.dim_16dp))
        ) {
            val (savedButton, sourceName) = createRefs()

            Text(
                text = news?.sourceModel?.name.orEmpty(),
                style = TextStyle(
                    color = MediumGrey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .constrainAs(sourceName) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            IntentHandler.openUrlIntent(
                                context = context,
                                url = news?.url.orEmpty()
                            )
                        }
                    )
            )
            Image(
                painter = if (existNews) painterResource(R.drawable.ic_saved_fill) else painterResource(
                    R.drawable.ic_saved
                ),
                contentDescription = Constants.EMPTY,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.dim_23dp),
                        dimensionResource(id = R.dimen.dim_23dp))
                    .constrainAs(savedButton) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            news?.let {
                                if (existNews)
                                    detailViewModel.fetchDeleteNews(it)
                                else
                                    detailViewModel.fetchSaveNews(it)
                            }
                        }
                    )
            )
        }

        Text(
            text = news?.title.orEmpty(),
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimensionResource(id = R.dimen.dim_16dp),
                    end = dimensionResource(id = R.dimen.dim_16dp),
                    top = dimensionResource(id = R.dimen.dim_8dp))
        )

        Text(
            text = news?.description.plus(news?.content?.removeExtraChars()),
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimensionResource(id = R.dimen.dim_16dp),
                    end = dimensionResource(id = R.dimen.dim_16dp),
                    top = dimensionResource(id = R.dimen.dim_15dp))
        )
    }

}
