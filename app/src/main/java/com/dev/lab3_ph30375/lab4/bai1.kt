package com.dev.lab3_ph30375.lab4

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dev.lab3_ph30375.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun Bai1Lab() {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    // Your code here
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        //logo here
        AsyncImage(
            model = "https://vareno.vn/wp-content/uploads/2021/07/logo-noi-that-9.jpg",
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(100.dp) // Adjust the height as needed
                .clip(RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Crop
        )

        // title here
        // text here
        Text(text = "Login", style = Typography.bodyLarge, modifier = Modifier.padding(10.dp))

        // input here password and email
        //text input here
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.padding(10.dp)
        )


        // button here login
        Button(
            onClick = {
                if (username.isNotBlank() && password.isNotBlank()) {
                    Toast.makeText(
                        context, "Login successful",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        context,

                        "Please enter username and password",
                        Toast.LENGTH_LONG

                    ).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text("Login")
        }
    }

    // button here register
}
