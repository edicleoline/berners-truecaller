package com.berners.truecaller.ui.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.berners.truecaller.R
import com.berners.truecaller.model.Incoming
import com.berners.truecaller.model.IncomingDirection
import com.berners.truecaller.model.Phone
import com.berners.truecaller.ui.theme.Casper
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.ui.theme.Typography
import com.berners.truecaller.ui.theme.Widget
import com.berners.truecaller.ui.theme.Widget.Sizes
import com.berners.truecaller.ui.widget.avatar.Avatar
import com.berners.truecaller.ui.widget.avatar.SelectableAvatar
import com.berners.truecaller.ui.widget.avatar.SpamAvatar
import com.berners.truecaller.ui.widget.phone.EntityName
import com.berners.truecaller.util.TimeUtils.simplePrettyDate
import com.berners.truecaller.util.parseColor
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CallHistory(
    modifier: Modifier,
    incoming: Incoming,
    loading: Boolean = false,
    selected: Boolean = false,
    selectOnClick: Boolean = false,
    onSelectChanged: (Boolean) -> Unit,
    onShowDetailsClick: (Phone) -> Unit
) {
    val selectedState = remember(selected) { mutableStateOf(selected) }
    val selectOnClickState = remember(selectOnClick) { mutableStateOf(selectOnClick) }
    val loadingState = remember(loading) { mutableStateOf(loading) }

    val target = when(incoming.direction) {
        IncomingDirection.INCOMING -> incoming.source
        IncomingDirection.OUTGOING -> incoming.target
    }

    val source = when(incoming.direction) {
        IncomingDirection.INCOMING -> incoming.target
        IncomingDirection.OUTGOING -> incoming.source
    }

    val info: String = if (target.location != null) {
        target.location?.formatted!!
    } else {
        "blabla"
    }

    val time = try {
        incoming.state.createdAt.toLocalDateTime(TimeZone.currentSystemDefault()).simplePrettyDate()
    } catch (exception: Exception) {
        ""
    }

    val primaryColor = if (incoming.state.missed || incoming.state.blocked) {
        MaterialTheme.colors.error
    } else {
        MaterialTheme.colors.primary
    }

    val primaryIcon: Int? = if (incoming.direction == IncomingDirection.OUTGOING) {
        R.drawable.ic_type_outgoing_call
    } else if (incoming.direction == IncomingDirection.INCOMING && incoming.state.missed) {
        R.drawable.ic_tcx_event_missed_call_16dp
    } else if (incoming.state.blocked) {
        R.drawable.ic_tcx_event_blocked_16dp
    } else if (incoming.state.declined) {
        R.drawable.ic_type_incoming_call_declined
    }  else {
        null
    }

    val primaryIconColor = MaterialTheme.colors.primaryVariant

    var avatarPrimaryColor = Casper
    if (target.entity != null) {
        target.entity?.primaryColor?.parseColor()?.let { avatarPrimaryColor = it }
    }

    val avatarSize = Sizes.MEDIUM.defaultSize

    modifier
        .fillMaxWidth()

    Surface(
        contentColor = MaterialTheme.colors.secondary,
        color = if (selectedState.value) MaterialTheme.colors.secondary.copy(0.1f) else MaterialTheme.colors.surface,
        modifier = modifier.combinedClickable(
            onClick = {
                if (selectedState.value) {
                    selectedState.value = false
                    triggerSelectChanged(lastValue = true, currentValue = false, onSelectChanged)
                } else if (selectOnClickState.value) {
                    selectedState.value = true
                    triggerSelectChanged(lastValue = false, currentValue = true, onSelectChanged)
                }
            },
            onDoubleClick = {},
            onLongClick = {
                if (!selectedState.value) {
                    selectedState.value = true
                    triggerSelectChanged(lastValue = false, currentValue = true, onSelectChanged)
                }
            },
            enabled = true,
            role = Role.Button
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(start = 12.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            if (selectedState.value) {
                SelectableAvatar(
                    modifier = Modifier.size(avatarSize)
                )
            } else {
                Avatar(
                    modifier = Modifier.size(Widget.Sizes.MEDIUM.defaultSize),
                    entity = target.entity,
                    tag = target.tag,
                    primaryColor = avatarPrimaryColor,
                    showVerifiedBadge = false,
                    spam = incoming.state.spam,
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, end = 4.dp)
            ) {
                EntityName(
                    phone = target,
                    color = primaryColor
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    var iconDrawn = false

                    if (primaryIcon != null) {
                        Icon(
                            painter = painterResource(id = primaryIcon),
                            tint = primaryIconColor,
                            contentDescription = null,
                            modifier = Modifier
                                .size(16.dp)
                        )
                        iconDrawn = true
                    }

                    if (
                        SimIcon(
                            modifier = Modifier
                                .size(16.dp)
                                .padding(start = 2.dp),
                            phone = source,
                            color = MaterialTheme.colors.primaryVariant
                        )
                    ) {
                        iconDrawn = true
                    }

                    if (iconDrawn) {
                        Spacer(modifier = Modifier.width(4.dp))
                    }

                    Text(
                        text = info,
                        style = Typography.body2,
                        color = MaterialTheme.colors.primaryVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .widthIn(0.dp, 120.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = time,
                        style = Typography.body2,
                        color = MaterialTheme.colors.primaryVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                    )

                    IconButton(
                        modifier = Modifier
                            .size(42.dp)
                            .widthIn(48.dp, 48.dp),
                        onClick = { onShowDetailsClick(target) }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_info),
                                tint = MaterialTheme.colors.primary,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun triggerSelectChanged(lastValue: Boolean, currentValue: Boolean, callback: (Boolean) -> Unit) {
    if (lastValue != currentValue) {
        callback(currentValue)
    }
}