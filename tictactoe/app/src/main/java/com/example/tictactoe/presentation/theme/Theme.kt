package com.example.tictactoe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.wear.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.tictactoe.presentation.theme.Shapes
import androidx.wear.compose.material.Colors
import androidx.wear.compose.material.Typography

private val DarkColorPalette = darkColors(
    primary = Color(0xFF1E88E5),
    primaryVariant = Color(0xFF1976D2),
    secondary = Color(0xFFE53935),
    background = Color.Black,
    surface = Color.DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF2196F3),
    primaryVariant = Color(0xFF1976D2),
    secondary = Color(0xFFF44336),
    background = Color.White,
    surface = Color.LightGray,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

val wearColors = Colors(
    primary = Color.Blue,
    primaryVariant = Color.White,
    secondary = Color.Green,
    // Define other colors as needed
)
@Composable
fun TicTacToeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = wearColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


