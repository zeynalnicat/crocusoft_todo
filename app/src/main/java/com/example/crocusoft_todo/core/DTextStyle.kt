package com.example.crocusoft_todo.core

import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.crocusoft_todo.ui.theme.Black
import com.example.crocusoft_todo.ui.theme.TextGray


object DTextStyle {

    val tTitle = TextStyle(
        fontSize = DsTheme.dimens.sp8,
        fontWeight = FontWeight.W700
    )

    val t12 = TextStyle(
        fontSize = DsTheme.dimens.sp1,
        fontWeight = FontWeight.W400,
    )

    val t12White = TextStyle(
        fontSize = DsTheme.dimens.sp1,
        color = White,
        fontWeight = FontWeight.W400,
    )

    val t14Bold = TextStyle(
        fontSize = DsTheme.dimens.sp2,
        fontWeight = FontWeight.W600
    )

    val t12Gray = TextStyle(
        fontSize = DsTheme.dimens.sp1,
        fontWeight = FontWeight.W600,
        color = Gray
    )

    val t18 = TextStyle(
        fontSize = DsTheme.dimens.sp3,
        color = White
    )

    val t17Medium = TextStyle(
        fontSize = DsTheme.dimens.s17,
        fontWeight = FontWeight.W500,
        color = Black
    )

    val t17SemiBold = TextStyle(
        fontSize = DsTheme.dimens.s17,
        fontWeight = FontWeight.W600,
        color = TextGray
    )

    val t14White = TextStyle(
        fontSize = DsTheme.dimens.sp2,
        color = White
    )


    val t12Bold =
        TextStyle(
            fontSize = DsTheme.dimens.sp1,
            fontWeight = FontWeight.W600,
            color = Black
        )

    val t8White = TextStyle(
        fontSize = DsTheme.dimens.sp0,
        fontWeight = FontWeight.W500,
        color = White

    )

    val t36SemiBold = TextStyle(
        fontSize = DsTheme.dimens.sp12,
        fontWeight = FontWeight.W600,
    )

}