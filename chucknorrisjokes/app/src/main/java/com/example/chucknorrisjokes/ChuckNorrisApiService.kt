package com.example.chucknorrisjokes
import retrofit2.http.GET

interface ChuckNorrisApiService {

    @GET("jokes/random")
    suspend fun getRandomJoke(): ChuckNorrisJoke
}
