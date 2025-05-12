package com.example.katas.domain.usecase

import com.example.katas.domain.model.MovieDetalle
import com.example.katas.domain.repository.MovieRepositoryDetailsAndRecommendations
import javax.inject.Inject

class GetMovieRecomendationsUseCaseImpl @Inject constructor(private val movieRepository: MovieRepositoryDetailsAndRecommendations) :
    GetMovieRecomendationsUseCase {
    override suspend fun execute(movieId: Int): List<MovieDetalle>{
        return movieRepository.getMovieRecomendations(movieId)
    }

}