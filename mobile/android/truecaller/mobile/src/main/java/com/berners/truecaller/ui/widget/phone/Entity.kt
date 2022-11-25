package com.berners.truecaller.ui.widget.phone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.berners.truecaller.R
import com.berners.truecaller.model.Phone
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.ui.theme.Typography

@Composable
fun EntityName(
    phone: Phone,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.subtitle2,
    color: Color = MaterialTheme.colors.primary,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    showVerifiedBadge: Boolean = true
) {
    var caption: String = if(phone.nationalFormat != null) phone.nationalFormat!! else phone.phone
    if (phone.entity != null && phone.entity!!.name != null && phone.entity!!.name!!.isNotBlank()) {
        caption = phone.entity!!.name.toString()
    }

    Box(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = caption,
                style = style,
                color = color,
                maxLines = maxLines,
                overflow = overflow,
                modifier = Modifier
                    .weight(7.5f, false)
            )
            if (showVerifiedBadge && phone.entity != null && phone.entity!!.verified) {
                Spacer(modifier = Modifier.width(4.dp))
                Column(
                    modifier = Modifier
                        .weight(1f, false)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_avatar_verified_badge),
                        tint = Color.Unspecified,
                        contentDescription = null,
                        modifier = Modifier
                            .size(18.dp)
                    )
                }
            }
        }
    }

}