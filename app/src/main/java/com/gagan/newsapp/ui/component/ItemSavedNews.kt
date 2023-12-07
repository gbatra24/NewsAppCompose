package com.gagan.newsapp.ui.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.gagan.newsapp.R
import com.gagan.newsapp.data.model.NewsModel
import com.gagan.newsapp.ui.screens.Screen
import com.gagan.newsapp.ui.theme.Grey
import com.gagan.newsapp.ui.theme.LightGrey
import com.gagan.newsapp.ui.theme.RippleGrey
import com.gagan.newsapp.ui.theme.RippleWhite
import com.gagan.newsapp.utils.constants.Constants
import com.gagan.newsapp.utils.constants.Constants.NEWS_BUNDLE_KEY
import com.gagan.newsapp.utils.extentions.putParcelableBundle
import com.gagan.newsapp.utils.library.paintImage

@ExperimentalCoilApi
@Composable
fun ItemSavedNews(
    news: NewsModel,
    navController: NavController
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dim_20dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.dim_8dp))
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGrey)
        ) {
            val (image, title) = createRefs()

            Image(
                painter = paintImage(image = news.urlToImage),
                contentDescription = Constants.EMPTY,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.dim_200dp))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dim_20dp)))
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(color = RippleWhite),
                        onClick = {
                            navController.putParcelableBundle(key = NEWS_BUNDLE_KEY, value = news)
                            navController.navigate(Screen.DetailScreen.withArgs(Constants.SCREEN_DETAILS))
                        }
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                RippleGrey
                            )
                        )
                    )
            ) {
                Text(
                    text = news.title,
                    style = TextStyle(
                        color = Grey,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 16.sp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(start = dimensionResource(id = R.dimen.dim_20dp),
                            end = dimensionResource(id = R.dimen.dim_20dp),
                            top = dimensionResource(id = R.dimen.dim_8dp),
                            bottom = dimensionResource(id = R.dimen.dim_8dp))
                )
            }
        }
    }
}