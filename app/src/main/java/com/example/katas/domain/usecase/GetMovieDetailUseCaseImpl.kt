package com.example.katas.domain.usecase

import com.example.katas.domain.model.MovieDetalle
import com.example.katas.domain.repository.MovieRepositoryDetailsAndRecommendations
import javax.inject.Inject

class GetMovieDetailUseCaseImpl @Inject constructor(
   private val  movieRepository: MovieRepositoryDetailsAndRecommendations
) : GetMovieDetailUseCase {
    override suspend fun  execute(movieId: Int): MovieDetalle?{
        return   movieRepository.getMovieDetails(movieId)
    }
}