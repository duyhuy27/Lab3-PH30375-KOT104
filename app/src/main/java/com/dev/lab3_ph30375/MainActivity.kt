package com.dev.lab3_ph30375

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.lab3_ph30375.ui.theme.Lab3_ph30375Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3_ph30375Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "bt5") {
                        composable("menu") {
                            Menu(navController)
                        }
                        composable("bai1") {
                            Bai1()
                        }
                        composable("bai2") {
                            bai2(navController = navController)
                        }
                        composable("bai3") {
//
                            Bai3()
                        }
                        composable("bt5") {
//
                            BT5()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Menu(navController: NavController) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Menu Lab 3",
                modifier = Modifier.padding(16.dp),
//            style = MaterialTheme.typography.bodyLarge,
//            color = MaterialTheme.colorScheme.onPrimary
            )
            Button(
                onClick = {
                    // navigate to Bai1
                    navController.navigate("bai1")


                },
                modifier = Modifier.padding(16.dp),
                content = {
                    Text("Bai 1")
                },

                )
            Button(
                onClick = { navController.navigate("bai2") },
                modifier = Modifier.padding(16.dp),
                content = {
                    Text("Bai 2")
                })
            Button(onClick = { navController.navigate("bai3") }, modifier = Modifier.padding(16.dp), content = {
                Text("Bai 3")
            })

        }
    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Lab3_ph30375Theme {
            Menu(navController = rememberNavController())
        }
    }
}