package com.kwancorp.todonyanapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kwancorp.todonyanapp.R
import com.kwancorp.todonyanapp.ui.theme.BorderColor
import com.kwancorp.todonyanapp.ui.theme.KeyColor
import com.kwancorp.todonyanapp.ui.theme.White

@Composable
fun AddBody() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row {
            Text("할일 추가")
            Image(
                painter = painterResource(R.drawable.ic_close),
                contentDescription = null
            )
        }
        TodoTitle()
        TodoGroup()
        RepeatCycle()
        Period()
        Notice()

        AddButton()
    }
}

@Composable
fun TodoTitle() {
    Text(text = "이름")

    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        modifier = Modifier
            .fillMaxWidth(),
        onValueChange = {text = it},
        placeholder = { Text("새로운 할 일을 입력해주세요") }
    )
}

@Composable
fun TodoGroup() {
    Text("그룹")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = BorderColor
            )
    ) {
        Text("기본 그룹")
    }
}

@Composable
fun RepeatCycle() {
    Text("반복 주기")

    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        RepeatCycleItem(day = "월")
        RepeatCycleItem(day = "화")
        RepeatCycleItem(day = "수")
        RepeatCycleItem(day = "목")
        RepeatCycleItem(day = "금")
        RepeatCycleItem(day = "토")
        RepeatCycleItem(day = "일")
    }
}

@Composable
fun RepeatCycleItem(day: String) {
    Text(
        text = day,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .border(
                width = 1.5.dp,
                color = BorderColor,
                shape = RoundedCornerShape(10.dp)
            ),
    )
}

@Composable
fun Period() {
    Text("기간")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = BorderColor
            )
    ) {
        Text("하루종일")
        Switch(
            checked = false,
            onCheckedChange = {}
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = BorderColor
            )
    ) {
        Text("시작 일시")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = BorderColor
            )
    ) {
        Text("종료 일시")
    }
}

@Composable
fun Notice() {
    Text("알림")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = BorderColor
            )
    ) {
        Text("알림 없음")
    }
}

@Composable
fun AddButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 1.0.dp,
                color = KeyColor,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = ButtonDefaults.buttonColors(backgroundColor = KeyColor),
        onClick = { }
    ) {
        Text(
            text = "추가하기",
            color = White
        )
    }
}