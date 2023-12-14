package com.gagan.newsapp.utils.library

import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.gagan.newsapp.R

@ExperimentalCoilApi
@Composable
fun paintImage(image: String): ImagePainter {
    return rememberImagePainter(
        data = image,
        builder = {
            placeholder(R.drawable.ic_launcher_background_grey)
            error(R.drawable.ic_launcher_background_grey)
        }
    )
}
