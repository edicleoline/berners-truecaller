package com.berners.truecaller.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Widget {
    enum class Sizes(val defaultSize: Dp) {
        SMALL(defaultSize = 24.dp),
        MEDIUM(defaultSize = 48.dp),
        LARGE(defaultSize = 72.dp)
    }
}
