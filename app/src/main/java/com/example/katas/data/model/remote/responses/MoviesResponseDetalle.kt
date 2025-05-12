package com.example.katas.data.model.remote.responses

import com.example.katas.data.model.entities.MovieDetalleDto

data class MoviesResponseDetalle(
    val page: Int?,
    val results: List<MovieDetalleDto>
)