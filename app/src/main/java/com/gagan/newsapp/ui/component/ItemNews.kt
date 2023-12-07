package com.gagan.newsapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.ui.screens.Screen
import com.gagan.newsapp.ui.theme.Grey
import com.gagan.newsapp.ui.theme.LightGrey
import com.gagan.newsapp.ui.theme.MediumGrey
import com.gagan.newsapp.ui.theme.RippleGrey
import com.gagan.newsapp.utils.constants.Constants.NEWS_BUNDLE_KEY
import com.gagan.newsapp.utils.extentions.putParcelableBundle
import com.gagan.newsapp.utils.library.paintImage
import com.gagan.newsapp.R
import com.gagan.newsapp.utils.constants.Constants

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ItemNews(
    news: NewsModel,
    navController: NavController
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightGrey)
            .padding(
                start = dimensionResource(R.dimen.dim_16dp),
                end = dimensionResource(R.dimen.dim_16dp),
                top = dimensionResource(R.dimen.dim_8dp),
                bottom = dimensionResource(R.dimen.dim_8dp)
            )
    ) {
        val (card, image) = createRefs()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dim_120dp))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dim_8dp)))
        ) {
            Image(
                painter = paintImage(image = news.urlToImage),
                contentDescription = Constants.EMPTY,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.dim_120dp),
                        dimensionResource(id = R.dimen.dim_120dp))
                    .clickable(
                        onClick = {
                            navController.putParcelableBundle(key = NEWS_BUNDLE_KEY, value = news)
                            navController.navigate(Screen.DetailScreen.withArgs(Constants.SCREEN_DETAILS))
                        }
                    )

            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(color = RippleGrey),
                        onClick = {
                            navController.putParcelableBundle(key = NEWS_BUNDLE_KEY, value = news)
                            navController.navigate(Screen.DetailScreen.withArgs(Constants.SCREEN_DETAILS))
                        }
                    )
            ) {
                Text(
                    text = news.title,
                    style = TextStyle(
                        color = Grey,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 16.sp,
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = dimensionResource(id = R.dimen.dim_12dp))
                )

                Text(
                    text = news.sourceModel?.name.orEmpty(),
                    style = TextStyle(
                        color = MediumGrey,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = dimensionResource(id = R.dimen.dim_12dp))
                )
            }
        }
    }
}