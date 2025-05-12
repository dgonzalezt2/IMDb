package com.example.katas.data.model.remote.responses

import com.example.katas.data.model.entities.MovieSearchDto

data class MoviesResponseSearch(
    val page: Int?,
    val results: List<MovieSearchDto>
)