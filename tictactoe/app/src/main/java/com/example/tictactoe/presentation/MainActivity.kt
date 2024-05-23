package com.example.tictactoe.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.wear.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.tictactoe.ui.TicTacToeGame
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TicTacToeGame()
                }
            }
        }
    }
}
