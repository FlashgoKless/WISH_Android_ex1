package com.example.wish_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wish_kotlin.ui.theme.WISH_KotlinTheme
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1Input = findViewById<EditText>(R.id.number1)
        val number2Input = findViewById<EditText>(R.id.number2)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultView = findViewById<TextView>(R.id.result)

        calculateButton.setOnClickListener {
            val num1 = number1Input.text.toString().toDoubleOrNull()
            val num2 = number2Input.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val sum = num1 + num2
                resultView.text = "Результат: $sum"
            } else {
                resultView.text = "Введите оба числа!"
            }
        }
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
    WISH_KotlinTheme {
        Greeting("Android")
    }
}