package com.example.katas.domain.usecase

import com.example.katas.data.model.remote.responses.MoviesResponseDetalle
import com.example.katas.domain.model.MovieDetalle

interface GetMovieRecomendationsUseCase {

    suspend fun  execute(movieId: Int): List<MovieDetalle>
}