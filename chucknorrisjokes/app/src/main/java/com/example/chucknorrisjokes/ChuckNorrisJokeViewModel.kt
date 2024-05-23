package com.example.chucknorrisjokes
import androidx.lifecycle.ViewModel

class ChuckNorrisJokeViewModel(private val repository: ChuckNorrisRepository) : ViewModel() {

    suspend fun getRandomJoke(): ChuckNorrisJoke {
        return repository.getRandomJoke()
    }
}
