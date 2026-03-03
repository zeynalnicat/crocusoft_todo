package com.example.crocusoft_todo.common.components

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.example.crocusoft_todo.core.Colors
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.presentation.home.HomeContract


@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = DsTheme.textStyle.t18,
    postIntent: (HomeContract.Intent) -> Unit,

) {

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(Colors.black)
        ),
        shape = RoundedCornerShape(DsTheme.dimens.dp3),
        onClick = { postIntent(HomeContract.Intent.OnAdd) }
    ) {

        Text(
            text = text,
            style = textStyle
        )
    }

}