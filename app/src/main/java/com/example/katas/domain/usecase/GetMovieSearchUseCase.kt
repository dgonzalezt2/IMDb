package com.example.katas.domain.usecase

import com.example.katas.domain.model.MovieSearch

interface GetMovieSearchUseCase {
    suspend fun execute(): List<MovieSearch>

}