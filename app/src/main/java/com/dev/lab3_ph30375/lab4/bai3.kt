package com.dev.lab3_ph30375.lab4

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Preview
@Composable
fun Bai3Lab4() {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        showDialogAddNew(onDismiss = { showDialog = false })

    }
    // Your code here
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                //show dialog to add new note
                showDialog = true


            }) {
                Icon(Icons.Filled.Add, contentDescription = "Localized description")
            }
        }

    ) { padding ->
        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

        }
        LazyColumn {
            items(listNote.size) { index ->
                NoteItem(index)
            }

        }
    }
}

@Composable
fun showDialogAddNew(onDismiss: () -> Unit) {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Add new note", style = MaterialTheme.typography.labelLarge)
        },
        text = {
            Column {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Title") })
                Spacer(modifier = androidx.compose.ui.Modifier.height(2.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Content") })
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
            TextButton(onClick = {
                if (username.isNotBlank() && password.isNotBlank()) {
                    listNote.add(Note(
                        title = username,
                        content = password
                    ))

                    onDismiss()
                    Toast.makeText(
                        context, "Add New Note successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else {
                    //show toast
                    Toast.makeText(
                        context, "Please enter title or content",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }) {
                Text(text = "Save")

            }
        }
    )
}

@Composable
fun NoteItem(index: Int) {
    val note = listNote[index]
    Box(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth().padding(8.dp)
            .background(color = Color.LightGray, shape =
            MaterialTheme.shapes.medium)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = note.title,
                modifier = androidx.compose.ui.Modifier.weight(1f).padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand Note",
                modifier =
                androidx.compose.ui.Modifier.padding(16.dp).align(Alignment.CenterVertically)
            )
        }
    }
}

data class Note(
    val title: String,
    val content: String
)

val listNote = mutableStateListOf(
    Note(
        title = "Note 1",
        content = "Content 1"
    ),
    Note(
        title = "Note 2",
        content = "Content 2"
    ),
    Note(
        title = "Note 3",
        content = "Content 3"
    ),
)

