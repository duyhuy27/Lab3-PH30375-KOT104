package com.dev.lab3_ph30375.lab4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Bai2Lab4() {
    // Your code here
    Scaffold (
        bottomBar = {
        }
    ) {
            padding -> Column (
        modifier = Modifier.padding(padding).fillMaxSize()
    ) {
        ProductSection()
    }

    }
}