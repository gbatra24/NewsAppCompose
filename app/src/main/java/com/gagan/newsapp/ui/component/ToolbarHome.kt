package com.gagan.newsapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.gagan.newsapp.ui.screens.Screen
import com.gagan.newsapp.ui.theme.MediumGrey
import com.gagan.newsapp.R
import com.gagan.newsapp.ui.theme.Grey
import com.gagan.newsapp.utils.constants.Constants

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ToolbarHome(
    navController: NavController
) {
    val scope = rememberCoroutineScope()

    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dim_60dp))
                .background(White)
        ) {
            val (title, favoriteImage) = createRefs()

            Text(
                text = stringResource(id = R.string.headline_news),
                style = TextStyle(
                    color = Grey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.dim_20dp),
                        dimensionResource(id = R.dimen.dim_10dp),
                        dimensionResource(id = R.dimen.dim_10dp),
                        dimensionResource(id = R.dimen.dim_10dp))
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    },
                fontFamily = FontFamily.SansSerif
            )

            Image(
                painter = painterResource(R.drawable.ic_saved),
                contentDescription = Constants.EMPTY,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.dim_25dp),
                        dimensionResource(id = R.dimen.dim_25dp))
                    .constrainAs(favoriteImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, margin = 30.dp)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            navController.navigate(Screen.SavedScreen.withArgs(Constants.SCREEN_DETAILS))
                        }
                    )
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