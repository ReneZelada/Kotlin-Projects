package com.example.tictactoe.model

data class Cell(val row: Int, val col: Int)

enum class Player {
    X, O
}

data class GameState(
    val board: List<List<Player?>> = List(3) { List(3) { null } },
    val currentPlayer: Player = Player.X,
    val winner: Player? = null,
    val draw: Boolean = false
)
