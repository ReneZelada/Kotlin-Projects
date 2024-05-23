package com.example.dicerol
import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableField
import java.util.*

class DiceViewModel : ViewModel() {
    val result: ObservableField<String> = ObservableField("")

    fun rollDice() {
        val randomNumber = Random().nextInt(6) + 1
        result.set(randomNumber.toString())
    }
}
