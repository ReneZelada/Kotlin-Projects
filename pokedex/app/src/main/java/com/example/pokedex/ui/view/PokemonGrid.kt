// ui/view/PokemonGrid.kt
package com.example.pokedex.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.pokedex.model.Pokemon
import com.example.pokedex.ui.viewmodel.PokemonViewModel

@Composable
fun PokemonGrid(onItemClick: (Pokemon) -> Unit) {
    val viewModel: PokemonViewModel = viewModel()
    val pokemons by viewModel.pokemons.observeAsState(listOf())

    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonListItem(pokemon = pokemon, onItemClick = onItemClick)
        }
    }
}

@Composable
fun PokemonListItem(pokemon: Pokemon, onItemClick: (Pokemon) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(pokemon) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(
                data = pokemon.imageUrl,
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = pokemon.name, style = MaterialTheme.typography.h6)
    }
}
