package com.example.crocusoft_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.crocusoft_todo.core.Colors
import com.example.crocusoft_todo.core.Drawables
import com.example.crocusoft_todo.core.DsTheme
import com.example.crocusoft_todo.domain.entity.TodoEntity
import com.example.crocusoft_todo.presentation.home.HomeContract


@Composable
fun TodoItem(
    todoEntity: TodoEntity,
    postIntent: (HomeContract.Intent) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(DsTheme.dimens.dp3))
            .background(color = colorResource(Colors.secondary))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(DsTheme.dimens.dp3)
                .fillMaxWidth()
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(DsTheme.dimens.dp4),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = todoEntity.isCompleted,
                    onCheckedChange = { postIntent(HomeContract.Intent.OnCheckedTodo(todoEntity)) }
                )

                Text(
                    text = todoEntity.taskName,
                    style = DsTheme.textStyle.t17Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Icon(
                painter = painterResource(Drawables.icon_frame),
                contentDescription = null
            )
        }
    }

}