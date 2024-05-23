// ui/view/PokemonDetails.kt
package com.example.pokedex.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.pokedex.model.Pokemon

@Composable
fun PokemonDetails(pokemon: Pokemon) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(pokemon.imageUrl),
            contentDescription = null,
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = pokemon.name, style = MaterialTheme.typography.h4)
        // Add more details if needed
    }
}
