package com.kwancorp.todonyanapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AddBody() {
    Column {
        Row {
            Text("할일 추가")
        }

        Text("이름")
        Text("새로운 할 일을 입력해주세요")
        Text("그룹")
        Text("반복 주기")
        Text("기간")
        Text("알림")
    }
}