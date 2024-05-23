package com.example.tictactoe.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.wear.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tictactoe.model.Cell
import com.example.tictactoe.model.Player
import ViewModel.TicTacToeViewModel

@Composable
fun TicTacToeGame(viewModel: TicTacToeViewModel = viewModel()) {
    val state = viewModel.state.collectAsState().value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        state.board.forEachIndexed { rowIndex, row ->
            Row {
                row.forEachIndexed { colIndex, cell ->
                    TicTacToeCell(
                        player = cell,
                        onClick = { viewModel.makeMove(Cell(rowIndex, colIndex)) }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        when {
            state.winner != null -> Text(
                text = "Winner: ${state.winner}",
                style = MaterialTheme.typography.body1
            )
            state.draw -> Text(
                text = "Draw",
                style = MaterialTheme.typography.body1
            )
            else -> Text(
                text = "Current Player: ${state.currentPlayer}",
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun TicTacToeCell(player: Player?, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(64.dp)
            .padding(4.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = player?.name ?: "",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}
