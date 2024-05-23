package ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tictactoe.model.Cell
import com.example.tictactoe.model.GameState
import com.example.tictactoe.model.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TicTacToeViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state: StateFlow<GameState> get() = _state

    fun makeMove(cell: Cell) {
        viewModelScope.launch {
            val currentState = _state.value
            if (currentState.board[cell.row][cell.col] != null || currentState.winner != null) return@launch

            val newBoard = currentState.board.mapIndexed { row, rowList ->
                rowList.mapIndexed { col, player ->
                    if (row == cell.row && col == cell.col) currentState.currentPlayer else player
                }
            }
            val winner = checkWinner(newBoard)
            val draw = checkDraw(newBoard)

            _state.value = GameState(
                board = newBoard,
                currentPlayer = if (currentState.currentPlayer == Player.X) Player.O else Player.X,
                winner = winner,
                draw = draw
            )
        }
    }

    private fun checkWinner(board: List<List<Player?>>): Player? {
        val lines = listOf(
            // Rows
            board[0], board[1], board[2],
            // Columns
            listOf(board[0][0], board[1][0], board[2][0]),
            listOf(board[0][1], board[1][1], board[2][1]),
            listOf(board[0][2], board[1][2], board[2][2]),
            // Diagonals
            listOf(board[0][0], board[1][1], board[2][2]),
            listOf(board[0][2], board[1][1], board[2][0])
        )
        return lines.firstOrNull { it.all { player -> player == Player.X } }?.first()
            ?: lines.firstOrNull { it.all { player -> player == Player.O } }?.first()
    }

    private fun checkDraw(board: List<List<Player?>>): Boolean {
        return board.flatten().all { it != null }
    }
}
