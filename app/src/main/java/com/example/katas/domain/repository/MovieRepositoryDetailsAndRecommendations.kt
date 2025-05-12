package com.example.katas.domain.repository

import com.example.katas.domain.model.MovieDetalle


interface MovieRepositoryDetailsAndRecommendations {
    suspend fun getMovieDetails(movieId: Int): MovieDetalle?
    suspend fun getMovieRecomendations(movieId: Int): List<MovieDetalle>
}