package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.crocusoft_todo.common.components.AppButton
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.core.Strings
import com.example.crocusoft_todo.presentation.home.HomeContract


@Composable
fun HomeSearchContainer(
    modifier: Modifier = Modifier,
    searchQuery: String,
    postIntent: (HomeContract.Intent) -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HomeSearchTextField(
            value = searchQuery,
            postIntent = postIntent
        )

        AppButton(
            modifier = Modifier.padding(DsTheme.dimens.dp1),
            text = stringResource(Strings.add),
            postIntent = postIntent,
            textStyle = DsTheme.textStyle.t14White
        )
    }
}