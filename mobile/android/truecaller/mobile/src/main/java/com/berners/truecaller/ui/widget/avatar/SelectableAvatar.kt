package com.berners.truecaller.ui.widget.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.berners.truecaller.R
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.ui.theme.Widget

@Composable
fun SelectableAvatar(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.secondary
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(Widget.Sizes.MEDIUM.defaultSize)
            .clip(CircleShape)
            .background(MaterialTheme.colors.surface)

    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_check_24),
            tint = color,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(0.6f)
        )
    }
}