package com.dev.lab3_ph30375

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.lab3_ph30375.ui.theme.Lab3_ph30375Theme

@Composable
fun bai2(navController: NavController) {
    var text by remember {
        mutableStateOf("Hello - Nguyen Duy Huy - PH30375")
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardText(msg = text)
        Button(
            onClick = { text = "Hi!" }, modifier = Modifier.padding(16.dp)) {
            Text(text = "Say hi")

        }
    }
}

@Composable
fun CardText(msg: String) {

    Text(
        text = msg,
        style = MaterialTheme.typography.bodyLarge,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun bai2Preview() {
    Lab3_ph30375Theme {
        val navController = rememberNavController();
        bai2(navController)
    }

}