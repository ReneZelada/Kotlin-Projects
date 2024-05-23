package com.example.chucknorrisjokes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChuckNorrisRepository {

    private val apiService: ChuckNorrisApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ChuckNorrisApiService::class.java)
    }

    suspend fun getRandomJoke(): ChuckNorrisJoke {
        return apiService.getRandomJoke()
    }
}
