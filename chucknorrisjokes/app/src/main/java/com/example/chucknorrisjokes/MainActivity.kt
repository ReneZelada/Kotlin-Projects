package com.example.chucknorrisjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: ChuckNorrisJokeViewModel by viewModels {
        ChuckNorrisJokeViewModelFactory(ChuckNorrisRepository())
    }

    private lateinit var jokeAdapter: ChuckNorrisJokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        fetchJokes()
    }

    private fun setupRecyclerView() {
        jokeAdapter = ChuckNorrisJokeAdapter(emptyList())
        recyclerViewJokes.apply {
            adapter = jokeAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun fetchJokes() {
        lifecycleScope.launch {
            val jokes = mutableListOf<ChuckNorrisJoke>()
            repeat(10) {
                val joke = viewModel.getRandomJoke()
                jokes.add(joke)
            }
            jokeAdapter.updateData(jokes)
        }
    }
}
