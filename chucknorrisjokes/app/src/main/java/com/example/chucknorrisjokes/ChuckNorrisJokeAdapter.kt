package com.example.chucknorrisjokes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChuckNorrisJokeAdapter(private var jokes: List<ChuckNorrisJoke>) :
    RecyclerView.Adapter<ChuckNorrisJokeAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokes[position]
        holder.bind(joke)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    fun updateData(newJokes: List<ChuckNorrisJoke>) {
        jokes = newJokes
        notifyDataSetChanged()
    }

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvJoke: TextView = itemView.findViewById(R.id.tvJoke)

        fun bind(joke: ChuckNorrisJoke) {
            tvJoke.text = joke.joke
        }
    }
}
