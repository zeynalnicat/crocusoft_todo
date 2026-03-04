package com.example.crocusoft_todo.common.components

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.example.crocusoft_todo.core.Colors
import com.example.crocusoft_todo.core.Drawables
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.presentation.home.HomeContract


@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Int = Colors.black,
    isText: Boolean = true,
    textStyle: TextStyle = DsTheme.textStyle.t18,
    action: () -> Unit,

    ) {

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(color)
        ),
        shape = RoundedCornerShape(DsTheme.dimens.dp3),
        onClick = action
    ) {

        if (isText) {
            Text(
                text = text,
                style = textStyle
            )
        } else {
            Icon(
                painter = painterResource(Drawables.remove),
                contentDescription = null
            )
        }

    }

}