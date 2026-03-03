package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.crocusoft_todo.core.Colors
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.core.Strings
import com.example.crocusoft_todo.presentation.home.HomeContract


@Composable
fun HomeSearchTextField(
    modifier: Modifier,
    value: String,
    postIntent: (HomeContract.Intent) -> Unit
) {

    TextField(
        modifier = modifier
            .widthIn(DsTheme.dimens.maxWidth),
        value = value,
        maxLines = 1,
        onValueChange = { postIntent(HomeContract.Intent.OnSetQuery(it)) },
        placeholder = {
            Text(
                text = stringResource(Strings.hint)
            )
        },
        shape = RoundedCornerShape(DsTheme.dimens.dp4),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(Colors.input_background),
            focusedContainerColor = colorResource(Colors.input_background),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        )

    )

}