package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import com.example.crocusoft_todo.core.Colors
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.presentation.home.HomeContract
import com.example.crocusoft_todo.ui.theme.Gray
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


@Composable
fun AppTabView(
    tabs: List<String>,
    state: HomeContract.State,
    postIntent: (HomeContract.Intent) -> Unit
) {

    val pagerState = rememberPagerState { tabs.size }
    val scope = rememberCoroutineScope()


    Column(
    ) {
        TabRow(
            containerColor = Color.Transparent,
            selectedTabIndex = pagerState.currentPage,
            indicator = {},
            divider = {}
        ) {
            tabs.forEachIndexed { index, string ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(DsTheme.dimens.dp2)
                        .clip(RoundedCornerShape(DsTheme.dimens.dp2))
                        .background(
                            color = if (isSelected) colorResource(Colors.primary) else colorResource(
                                Colors.secondary
                            )
                        )
                        .padding(
                            DsTheme.dimens.dp2
                        )

                        .clickable(
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(page = index)
                                }
                            },
                        )

                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = string,
                        style = if (isSelected) DsTheme.textStyle.t12Bold else DsTheme.textStyle.t12Gray
                    )
                }

            }
        }

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false

            ) { page ->

            when (page) {
                1 -> TodoList(todos = state.allTodos, postIntent = postIntent)
                2 -> TodoList(todos = state.activeTodos, postIntent = postIntent)
                3 -> TodoList(todos = state.completedTodos, postIntent = postIntent)
            }
        }


    }


}