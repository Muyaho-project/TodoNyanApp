package com.kwancorp.todonyanapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.kwancorp.todonyanapp.R

@Composable
fun CatBody() {
    Column {
        Image(
            painter = painterResource(R.drawable.bg_cat_room),
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            contentDescription = null
        )

        Row {
            Text("함께하는 중인 투두냥")
            Text("3")
        }

        Row {
            Text("만나고 싶은 투두냥")
            Text("32")
        }
    }
}