// ui/view/NavGraph.kt
package com.example.pokedex.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.model.Pokemon
import com.example.pokedex.repository.PokemonRepository

sealed class Screen(val route: String) {
    object PokemonGrid : Screen("pokemonGrid")
    object PokemonDetails : Screen("pokemonDetails/{pokemonId}") {
        fun createRoute(pokemonId: Int) = "pokemonDetails/$pokemonId"
    }
}

@Composable
fun NavGraph(startDestination: String = Screen.PokemonGrid.route) {
    val navController = rememberNavController()
    val repository = remember { PokemonRepository() }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.PokemonGrid.route) {
            PokemonGrid { pokemon ->
                navController.navigate(Screen.PokemonDetails.createRoute(pokemon.id))
            }
        }
        composable(
            route = Screen.PokemonDetails.route,
            arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getInt("pokemonId")
            val pokemon = repository.getPokemonById(pokemonId)
            pokemon?.let {
                PokemonDetails(it)
            }
        }
    }
}
