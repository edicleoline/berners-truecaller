package com.berners.truecaller.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.BitmapPalette

//https://github.com/skydoves/DisneyCompose/blob/833fa311c0bc355c4f630fed4970bade56785d8a/app/src/main/java/com/skydoves/disneycompose/utils/NetworkImage.kt
@Preview
@Composable
fun NetworkImage(
    @PreviewParameter(NetworkUrlPreviewProvider::class) url: String,
    modifier: Modifier = Modifier,
    circularRevealEnabled: Boolean = false,
    contentScale: ContentScale = ContentScale.Crop,
    bitmapPalette: BitmapPalette? = null,
    failure: (() -> Unit)? = null
) {
    GlideImage(
        imageModel = url,
        modifier = modifier,
        contentScale = contentScale,
        circularReveal = CircularReveal(duration = 300).takeIf { circularRevealEnabled },
        bitmapPalette = bitmapPalette,
//        previewPlaceholder = R.drawable.poster,
//        shimmerParams = ShimmerParams(
//            baseColor = MaterialTheme.colors.background,
//            highlightColor = shimmerHighLight,
//            dropOff = 0.65f
//        ),
        failure = {
            if (failure != null) {
                failure.invoke()
            } else {
                Column(
                    modifier = modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "image request failed.",
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        },
    )
}