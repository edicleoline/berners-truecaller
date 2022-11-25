package com.berners.truecaller.ui.widget

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.berners.truecaller.R
import com.berners.truecaller.model.Phone
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.util.SimUtils

@Composable
fun SimIcon(
    modifier: Modifier = Modifier
        .size(16.dp),
    phone: Phone,
    color: Color = MaterialTheme.colors.primaryVariant
): Boolean {
    var simIcon: Int? = if (SimUtils.multipleSims()) {
        val sim = phone.e164Format?.let { SimUtils.getSimByPhoneNumber(it) }
        if (sim != null) {
            when (sim.slotIndex) {
                1 -> R.drawable.ic_sim1
                2 -> R.drawable.ic_sim2
                else -> null
            }
        } else null
    } else null

    if (simIcon != null) {
        Icon(
            painter = painterResource(id = simIcon),
            contentDescription = null,
            tint = color,
            modifier = modifier
        )

        return true
    }

    return false
}