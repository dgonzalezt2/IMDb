package com.example.katas.data.mappers

import com.example.katas.data.model.entities.MovieSearchDto
import com.example.katas.domain.model.MovieSearch
// Mapper para convertir MovieSearchDto a MovieSearch
fun MovieSearchDto.toDomainModel(): MovieSearch{
    return MovieSearch(
        id = this.id,
        title = this.title,
        releaseDate = this.releaseDate,
        overview = this.overview,
        posterPath = this.posterPath
    )
}

// Mapper para convertir una lista de MovieSearchDto a una lista de MovieSearch
fun List<MovieSearchDto>.toDomainModelList(): List<MovieSearch>{
    return this.map { it.toDomainModel() }
}