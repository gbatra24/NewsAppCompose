package com.gagan.newsapp.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.gagan.newsapp.R
import com.gagan.newsapp.ui.theme.ShimmerColorShades

@Composable
fun ShimmerHomeScreen() {
    HomeScreenShimmerAnimation()
}

@Composable
@Preview
fun HomeScreenShimmerAnimation() {
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 3000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800,
                easing = FastOutSlowInEasing,
                delayMillis = 100
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )

    HomeScreenShimmerItem(brush = brush)
}

@Composable
fun HomeScreenShimmerItem(
    brush: Brush
) {
    LazyColumn {

        repeat(6) {
            item {
                Row(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dim_16dp),
                    start = dimensionResource(id = R.dimen.dim_16dp),
                    end = dimensionResource(id = R.dimen.dim_16dp))) {
                    Spacer(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.dim_120dp))
                            .width(dimensionResource(id = R.dimen.dim_120dp))
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dim_10dp)))
                            .background(brush = brush)
                    )

                    Column(modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.dim_16dp))) {
                        Spacer(
                            modifier = Modifier
                                .absolutePadding(
                                    top = dimensionResource(id = R.dimen.dim_20dp),
                                    left = dimensionResource(id = R.dimen.dim_10dp)
                                )
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.dim_15dp))
                                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dim_3dp)))
                                .background(brush = brush)
                        )

                        Spacer(
                            modifier = Modifier
                                .absolutePadding(top = dimensionResource(id = R.dimen.dim_10dp),
                                    left = dimensionResource(id = R.dimen.dim_10dp))
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.dim_15dp))
                                .clip(RoundedCornerShape(
                                    dimensionResource(id = R.dimen.dim_3dp)))
                                .background(brush = brush)
                        )

                        Spacer(
                            modifier = Modifier
                                .absolutePadding(
                                    top = dimensionResource(id = R.dimen.dim_20dp),
                                    left = dimensionResource(id = R.dimen.dim_10dp))
                                .width(dimensionResource(id = R.dimen.dim_100dp))
                                .height(dimensionResource(id = R.dimen.dim_10dp))
                                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dim_3dp)))
                                .background(brush = brush)
                        )
                    }
                }
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.dim_15dp))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dim_10dp)))
            )
        }
    }
}