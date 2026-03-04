package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    isEditAction: Boolean = false,
    postIntent: (HomeContract.Intent) -> Unit,

    ) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HomeSearchTextField(
            modifier = Modifier.weight(0.8f),
            value = searchQuery,
            postIntent = postIntent
        )

        Row(
            modifier = Modifier
                .padding(DsTheme.dimens.dp1),
            horizontalArrangement = Arrangement.spacedBy(DsTheme.dimens.dp1),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (isEditAction) {
                IconButton(
                    onClick = { postIntent(HomeContract.Intent.OnClear) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null
                    )
                }
            }

            AppButton(

                text = if (!isEditAction) stringResource(Strings.add) else stringResource(Strings.edit),
                action = { postIntent(HomeContract.Intent.OnAdd) },
                textStyle = DsTheme.textStyle.t14White
            )
        }


    }
}