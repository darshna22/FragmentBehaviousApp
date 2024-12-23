package com.my.fragmentbehaviousapp.resultapifragment


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Jetpack Compose UI for the EditText
@Composable
fun InputFieldScreen(onValueChangeData: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                onValueChangeData(text)
            },
            label = { Text("Enter Text") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "You entered: $text",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


// Preview the Composable (optional, for development)
@Preview(showBackground = true)
@Composable
fun PreviewInputFieldScreen() {
    MaterialTheme {
        InputFieldScreen { message ->
        }
    }
}


