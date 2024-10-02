package com.example.network

class MovieRemoteDataSource(
    private val retrofitService: MovieApiService
) {
    suspend fun getPopularMovies(): List<Movie> {
        val apiKey = "fa3e844ce31744388e07fa47c7c5d8c3"
        return retrofitService.getPopularMovies(apiKey).results
    }
}