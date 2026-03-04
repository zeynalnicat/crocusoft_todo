package com.example.crocusoft_todo.presentation.splash

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.example.crocusoft_todo.presentation.home.HomeContract
import com.example.crocusoft_todo.ui.navigation.AppRoutes
import kotlinx.coroutines.flow.SharedFlow


@Composable
fun SplashContent(
    navController: NavController,
    effect: SharedFlow<SplashContract.Effect>,
    postIntent: (SplashContract.Intent) -> Unit
) {


    LaunchedEffect(Unit) {
        postIntent(SplashContract.Intent.CheckLog)
    }

    LaunchedEffect(effect) {
        effect.collect {
            when (it) {
                SplashContract.Effect.Navigate -> navController.navigate(AppRoutes.HomeScreen.route)
            }
        }
    }



    Scaffold(

    ) { innerPadding ->


        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(Drawables.onboarding),
                contentDescription = null,
                contentScale = ContentScale.Crop


            )

            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(DsTheme.dimens.dp5)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxSize()
                        .offset(x = 0.dp, y = 0.dp)
                ) {

                }

                Box(
                    modifier = Modifier
                        .offset(x = 0.dp, y = (-150).dp)
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = stringResource(Strings.splash_title),
                        style = DTextStyle.t36SemiBold
                    )

                }

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
                            postIntent(SplashContract.Intent.HandleLog)
                        }

                    }
                }
            }


        }
    }


}