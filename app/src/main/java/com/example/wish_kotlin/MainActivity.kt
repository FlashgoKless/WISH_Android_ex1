package com.example.wish_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wish_kotlin.ui.theme.WISH_KotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WISH_KotlinTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var number1 by rememberSaveable { mutableStateOf("") }
    var number2 by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // First number input
        TextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text(text = stringResource(id = R.string.hint_number1)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Second number input
        TextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text(text = stringResource(id = R.string.hint_number2)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Calculate button
        Button(
            onClick = {
                val num1 = number1.toDoubleOrNull()
                val num2 = number2.toDoubleOrNull()

                if (num1 != null && num2 != null) {
                    val sum = num1 + num2

                    // Send sum to the next activity
                    val intent = Intent(context, ResultActivity::class.java)
                    intent.putExtra("SUM_RESULT", sum)
                    context.startActivity(intent)
                } else {
                    // Show error if numbers are invalid
                    Toast.makeText(context, context.getString(R.string.error_message), Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.app_name))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WISH_KotlinTheme {
        MainScreen()
    }
}