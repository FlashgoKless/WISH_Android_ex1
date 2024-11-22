package com.example.wish_kotlin.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

// Пример цветовой схемы
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6)
)

@Composable
fun SumApp(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    // Можно использовать тему, основанную на darkTheme, или создавать свою кастомную тему.
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    androidx.compose.material3.MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SumApp {
    }
}