package com.gagan.newsapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.gagan.newsapp.ui.theme.Grey
import com.gagan.newsapp.ui.theme.MediumGrey
import com.gagan.newsapp.R
import com.gagan.newsapp.utils.constants.Constants

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ToolbarSaved(
    navController: NavController
) {
    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dim_60dp))
                .background(White)
        ) {
            val (backImage, titleText) = createRefs()

            Image(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = Constants.EMPTY,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(
                        dimensionResource(id = R.dimen.dim_17dp),
                        dimensionResource(id = R.dimen.dim_17dp)
                    )
                    .constrainAs(backImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 20.dp)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { navController.navigateUp() }
                    )
            )

            Text(
                text = stringResource(id = R.string.saved),
                style = TextStyle(
                    color = Grey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                ),
                modifier = Modifier
                    .constrainAs(titleText) {
                        top.linkTo(parent.top, margin = 5.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                        start.linkTo(backImage.end, margin = 10.dp)
                    }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dim_0_5dp))
                .background(MediumGrey)
        )
    }
}