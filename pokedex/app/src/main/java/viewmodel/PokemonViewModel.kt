// ui/viewmodel/PokemonViewModel.kt
package com.example.pokedex.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.model.Pokemon
import com.example.pokedex.repository.PokemonRepository

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()
    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        _pokemons.value = repository.getPokemons()
    }
}
