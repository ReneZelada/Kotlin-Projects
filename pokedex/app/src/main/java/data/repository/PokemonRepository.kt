// repository/PokemonRepository.kt
package com.example.pokedex.repository

import com.example.pokedex.model.Pokemon

class PokemonRepository {
    fun getPokemons(): List<Pokemon> {
        return listOf(
            Pokemon(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
            Pokemon(4, "Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
            Pokemon(7, "Squirtle", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png")
        )
    }

    fun getPokemonById(pokemonId: Int?): Pokemon? {
        return getPokemons().find { it.id == pokemonId }
    }
}
