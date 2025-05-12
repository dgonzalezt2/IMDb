package com.example.katas.data.network

import com.example.katas.data.model.entities.MovieDetalleDto
import com.example.katas.data.model.remote.responses.MoviesResponseDetalle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterfaceDetalle {
    @GET("{movie_id}/recommendations?api_key=c5c47722a4adcc77f6e84f28a48b857a")
    suspend fun getMovieRecomendations(@Path("movie_id") movieId: Int): Response<MoviesResponseDetalle>

    @GET("{movie_id}?api_key=c5c47722a4adcc77f6e84f28a48b857a")
    suspend fun getMovieDetails(
        @Path("movie_id")  movieId: Int
    ): Response<MovieDetalleDto>
}