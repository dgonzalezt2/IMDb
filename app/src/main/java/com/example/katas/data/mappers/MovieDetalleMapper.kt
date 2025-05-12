package com.example.katas.data.mappers

import com.example.katas.data.model.remote.responses.MoviesResponseDetalle
import com.example.katas.domain.model.MovieDetalle as DomainMovieDetalle
import com.example.katas.data.model.entities.MovieDetalleDto as DataMovieDetalle
// Mapper para convertir DataMovieDetalle a DomainMovieDetalle
fun DataMovieDetalle.toDomainModel():DomainMovieDetalle{
    return  DomainMovieDetalle(
        id = this.id ?: 0,
        rating = this.rating ?: "No rating",  // Valor por defecto
        posterPath = this.posterPath ?: "default_poster.jpg",  // Valor por defecto
        backdropPath = this.backdropPath ?: "default_backdrop.jpg",  // Valor por defecto
        originalTitle = this.originalTitle ?: "Unknown",  // Valor por defecto
        title = this.title ?: "Untitled",  // Valor por defecto
        overview = this.overview ?: "No overview available",  // Valor por defecto
        genres = this.genres?.map { it.toDomainModel() } ?: emptyList()  // Maneja géneros nulos
    )

}
// Mapper para convertir una lista de DataMovieDetalle a una lista de DomainMovieDetalle
fun List<DataMovieDetalle>.toDomainModelList(): List<DomainMovieDetalle>{
    return  this.map { it.toDomainModel() }
}
// Mapper para convertir MoviesResponseDetalle a una lista de DomainMovieDetalle
fun MoviesResponseDetalle.toDomainModelList():  List<DomainMovieDetalle>{
    return  results.toDomainModelList()
}