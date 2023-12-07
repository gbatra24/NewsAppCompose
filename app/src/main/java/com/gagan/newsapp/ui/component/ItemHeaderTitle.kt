package com.gagan.newsapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.gagan.newsapp.ui.theme.Grey
import com.gagan.newsapp.ui.theme.LightGrey
import com.gagan.newsapp.R

@Preview
@Composable
fun ItemHeaderTitle(title: String = "Title") {
    Text(
        text = title,
        style = TextStyle(
            color = Grey,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.dim_20dp),
                dimensionResource(id = R.dimen.dim_10dp),
                dimensionResource(id = R.dimen.dim_10dp),
                dimensionResource(id = R.dimen.dim_10dp))
            .background(LightGrey),
        fontFamily = FontFamily.SansSerif
    )
}