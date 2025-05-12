package com.example.katas.data.model.remote.responses

import com.example.katas.data.model.entities.MovieTopRatedAndPopularDto

data class MoviesResponseTopRatedAndPopular(
    val page: Int?,
    val results: List<MovieTopRatedAndPopularDto>
)