package com.example.katas.domain.model

data class MovieDetalle (
    val id: Int,
    val rating: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val title: String?,
    val originalTitle: String?,
    val overview: String?,
    val genres: List<Genero>
)