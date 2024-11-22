package com.example.wish_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sum = intent.getDoubleExtra("SUM_RESULT", 0.0)

            ResultScreen(sum)
        }
    }
}

@Composable
fun ResultScreen(sum: Double) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.result, sum))
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    ResultScreen(sum = 0.0)
}
