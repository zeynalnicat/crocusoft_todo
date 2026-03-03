package com.example.crocusoft_todo.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crocusoft_todo.common.components.AppButton
import com.example.crocusoft_todo.core.DTextStyle
import com.example.crocusoft_todo.core.Drawables
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.core.Strings
import com.example.crocusoft_todo.ui.navigation.AppRoutes


@Composable
fun SplashContent(
    navController: NavController
) {
    Scaffold(

    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(DsTheme.dimens.dp5)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 0.dp)
                    .rotate(-28f)
            ) {
                Image(
                    painter = painterResource(Drawables.splash),
                    contentDescription = null,
                )
            }
            Text(
                text = stringResource(Strings.splash_title),
                style = DTextStyle.t36SemiBold
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(DsTheme.dimens.dp9),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        modifier = Modifier.size(
                            width = DsTheme.dimens.splashWidth,
                            height = DsTheme.dimens.splashHeight
                        ),
                        painter = painterResource(Drawables.splash_tags),
                        contentDescription = null
                    )

                    AppButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(Strings.splash_continue)
                    ) {
                        navController.navigate(AppRoutes.HomeScreen.route)
                    }

                }
            }
        }


    }

}