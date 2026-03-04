package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.crocusoft_todo.common.components.AppButton
import com.example.crocusoft_todo.core.Colors
import com.example.crocusoft_todo.core.Drawables
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.presentation.home.HomeContract
import kotlin.math.roundToInt


@Composable
fun TodoItem(
    todoEntity: TodoEntity,
    postIntent: (HomeContract.Intent) -> Unit,
) {


    var offsetX by remember { mutableFloatStateOf(0f) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    offsetX = (offsetX + dragAmount).coerceIn(-300f, 0f)
                }
            }
    ) {

        if (!todoEntity.isCompleted) {
            Row(
                modifier = Modifier
                    .padding(horizontal = DsTheme.dimens.dp4)
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                AppButton(
                    text = "",
                    isText = false,
                    color = Colors.red,
                ) {
                    postIntent(HomeContract.Intent.OnDeleteTodo(todoEntity))
                }

            }
        }





        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(offsetX.roundToInt(), 0) }


        ) {
            Row(
                modifier = Modifier
                    .padding(DsTheme.dimens.dp3)
                    .fillMaxWidth()

                    .clip(RoundedCornerShape(DsTheme.dimens.dp3))

                    .background(
                        color = if (!todoEntity.isCompleted) colorResource(Colors.secondary) else Color.Transparent
                    )
                    .border(
                        border = if (todoEntity.isCompleted) BorderStroke(
                            width = DsTheme.dimens.dp01, color = colorResource(
                                Colors.faded
                            ).copy(alpha = 0.1f)
                        ) else BorderStroke(
                            width = DsTheme.dimens.dp02,
                            color = Color.Transparent
                        )
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(DsTheme.dimens.dp1),
                    horizontalArrangement = Arrangement.spacedBy(DsTheme.dimens.dp2),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = todoEntity.isCompleted,
                        onCheckedChange = {
                            if (!todoEntity.isCompleted) {
                                postIntent(HomeContract.Intent.OnCheckedTodo(todoEntity))
                            }

                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(Colors.black).copy(alpha = 0.4f)
                        )
                    )

                    Text(
                        text = todoEntity.taskName,
                        style = if (!todoEntity.isCompleted) DsTheme.textStyle.t17Medium else DsTheme.textStyle.t17MediumFaded,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                if (!todoEntity.isCompleted) {
                    Icon(
                        painter = painterResource(Drawables.icon_frame),
                        contentDescription = null
                    )
                }


            }


        }
    }


}