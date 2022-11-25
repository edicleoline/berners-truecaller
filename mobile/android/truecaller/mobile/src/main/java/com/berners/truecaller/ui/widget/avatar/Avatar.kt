package com.berners.truecaller.ui.widget.avatar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.berners.truecaller.R
import com.berners.truecaller.model.Entity
import com.berners.truecaller.model.EntityType
import com.berners.truecaller.model.Tag
import com.berners.truecaller.ui.compose.NetworkImage
import com.berners.truecaller.ui.theme.Arakoa
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.ui.theme.Typography
import com.berners.truecaller.ui.theme.Widget

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    entity: Entity? = null,
    tag: Tag? = null,
    spam: Boolean = false,
    textStyle: TextStyle = Typography.caption,
    circularRevealEnabled: Boolean = false,
    contentScale: ContentScale = ContentScale.Crop,
    primaryColor: Color = MaterialTheme.colors.primary.copy(alpha = 0.6f),
    showVerifiedBadge: Boolean = true,
    loading: Boolean = false
) {
    val loadingState by remember { mutableStateOf(loading) }

    val icon = when(entity?.type) {
        EntityType.PEOPLE -> R.drawable.ic_user
        EntityType.COMPANY -> R.drawable.ic_user
        else -> R.drawable.ic_user
    }

    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(Widget.Sizes.MEDIUM.defaultSize)
    ) {
        AnimatedVisibility(
            visible = loadingState,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            CircularProgressIndicator(
                strokeWidth = 1.dp,
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(2f)
            )
        }

        var wrapModifier = Modifier.fillMaxSize()
        if (loadingState) {
            wrapModifier = Modifier
                .height(this@BoxWithConstraints.maxHeight.minus(6.dp))
                .width(this@BoxWithConstraints.maxWidth.minus(6.dp))
        }

        Box(
            modifier = wrapModifier
        ) {
            if (showVerifiedBadge && entity != null && entity.verified) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_avatar_verified_badge),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .zIndex(2f)
                        .size(18.dp)
                        .absoluteOffset(x = 0.dp, y = 0.dp)
                )
            }

            if (entity != null && entity.isUser) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_tcx_badge_user_with_ring_24dp),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .zIndex(2f)
                        .size(18.dp)
                        .absoluteOffset(x = 0.dp, y = 0.dp)
                )
            }

            Box(
                modifier
                    .fillMaxSize()
                    .zIndex(1f),
                contentAlignment = Alignment.Center
            ) {
                if (spam) {
                    SpamAvatar(
                        modifier = Modifier.fillMaxSize()
                    )
                }
                else if(entity != null && !entity.defaultProfileImage) {
                    NetworkImage(
                        url = entity.profileImageUrl!!,
                        circularRevealEnabled = circularRevealEnabled,
                        contentScale = contentScale,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .clip(CircleShape)
                            .fillMaxSize(),
                    )
                } else if (tag != null) {
                    TagAvatar(
                        tag = tag,
                        primaryColor = primaryColor
                    )
                } else {
                    val initials = ((entity?.firstName?.take(1) ?: "") + (entity?.lastName?.take(1) ?: "")).uppercase()
                    if (initials.isNotEmpty()) {
                        NameAvatar(
                            initials = initials,
                            primaryColor = primaryColor,
                            textStyle = textStyle,
                            textColor = Color.White
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = icon),
                            tint = primaryColor,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }

//            if (!entity.profileImageUrl.isNullOrEmpty() && shouldLoadProfileImage) {
//                LaunchedEffect(key1 = true) {
//                    delay(3000)
//                    shouldShowLoading = true
//                    shouldLoadProfileImage = false
//                }
//            }
            }
        }


    }
}

@Composable
fun NameAvatar(
    modifier: Modifier = Modifier,
    initials: String,
    primaryColor: Color = Arakoa,
    textStyle: TextStyle = Typography.caption,
    textColor: Color = Color.White
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .clip(CircleShape)
            .background(primaryColor)
    ) {
        Text(text = initials, style = textStyle, color = textColor)
    }
}

@Composable
fun SpamAvatar(
    modifier: Modifier = Modifier,
    primaryColor: Color = MaterialTheme.colors.error
) {
    val icon = R.drawable.ic_tcx_caption_spam_12dp

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(Widget.Sizes.MEDIUM.defaultSize)
            .clip(CircleShape)
            .background(primaryColor.copy(0.3f))
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = primaryColor,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(0.6f)
        )
    }
}

@Composable
fun TagAvatar(
    modifier: Modifier = Modifier,
    tag: Tag,
    primaryColor: Color = Arakoa
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .clip(CircleShape)
            .background(primaryColor)
    ) {
        TagAvatarIcon(
            modifier = Modifier.fillMaxSize(0.5f),
            tag = tag,
        )
    }
}

@Composable
fun TagAvatarIcon(
    modifier: Modifier = Modifier,
    tag: Tag,
    color: Color = Color.White
) {
    var icon = when(tag.label) {
        "bank" -> R.drawable.ic_tcx_account_insights
        else -> R.drawable.ic_general_services
    }

    Icon(
        painter = painterResource(id = icon),
        tint = color,
        contentDescription = null,
        modifier = modifier
    )
}