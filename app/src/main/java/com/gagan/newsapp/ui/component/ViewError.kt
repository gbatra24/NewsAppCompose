package com.gagan.newsapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.gagan.newsapp.ui.theme.Grey
import com.gagan.newsapp.R
import com.gagan.newsapp.utils.constants.Constants

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ViewError(
    tryAgainClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.no_internet),
            contentDescription = Constants.EMPTY,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.dim_70dp))
                .fillMaxWidth()
        )

        Text(
            text = stringResource(id = R.string.error_internet_connection),
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.dim_10dp))
        )

        OutlinedButton(
            onClick = { tryAgainClick.invoke() },
            border = BorderStroke(dimensionResource(id = R.dimen.dim_1dp), Grey),
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.dim_20dp)),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.LightGray)
        ){
            Text( text = "try again" )
        }
    }
}