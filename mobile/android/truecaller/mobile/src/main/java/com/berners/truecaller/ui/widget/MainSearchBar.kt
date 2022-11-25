package com.berners.truecaller.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.berners.truecaller.R
import com.berners.truecaller.ui.compose.util.GlideImage
import com.berners.truecaller.ui.theme.TruecallerTheme
import com.berners.truecaller.ui.theme.Typography
import com.berners.truecaller.ui.theme.mainSearchText
import kotlinx.coroutines.launch

@Composable
fun MainSearchBar(
    modifier: Modifier
) {
//    val coroutineScope = rememberCoroutineScope()

    Surface(
        modifier = modifier
            .height(50.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .padding(10.dp)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(onClick = { /*coroutineScope.launch { scaffoldState.drawerState.open() }*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            tint = MaterialTheme.colors.onPrimary,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 8.dp, top = 5.dp, end = 8.dp, bottom = 5.dp),
                        )
                    }
                }
//            Spacer(modifier = Modifier.width(14.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = stringResource(id = R.string.main_search),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = Typography.mainSearchText,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .padding(end = 10.dp)
                    )
                }
//            Column(
//
//            ) {
//                GlideImage(
//                    modifier = Modifier
//                        .width(34.dp)
//                        .height(34.dp)
//                        .clip(RoundedCornerShape(200.dp)),
//                    contentDescription = "",
//                    data = "https://pbs.twimg.com/profile_images/859982100904148992/hv5soju7_reasonably_small.jpg",
//                    contentScale = ContentScale.Fit
//                )
//            }
            }
        }
    }


}