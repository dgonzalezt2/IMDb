package com.example.katas.data.repository

import android.util.Log
import com.example.katas.data.mappers.toDomainModel
import com.example.katas.data.mappers.toDomainModelList
import com.example.katas.data.network.ApiInterfaceDetalle
import com.example.katas.domain.model.MovieDetalle
import com.example.katas.domain.repository.MovieRepositoryDetailsAndRecommendations
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryDetailsAndRecommendationsImpl @Inject constructor(private val apiService: ApiInterfaceDetalle) :
    MovieRepositoryDetailsAndRecommendations {

    override suspend fun getMovieDetails(movieId: Int): MovieDetalle? {
        return try {
            val response = apiService.getMovieDetails(movieId)
            if (response.isSuccessful) {
                response.body()?.toDomainModel()
            } else {
                throw Exception("Error en la respuesta: ${response.code()} - ${response.message()}")
            }


        } catch (e: IOException) {
            throw Exception("Error de red: ${e.message}")

        } catch (e: HttpException) {
            throw Exception("Error Http: ${e.message()}")
        }
    }

    override suspend fun getMovieRecomendations(movieId: Int): List<MovieDetalle> {
        return try {
            val response = apiService.getMovieRecomendations(movieId)
            if (response.isSuccessful) {
                response.body()?.toDomainModelList()!!
            } else {
                Log.e(
                    "MovieRepository",
                    "Error en la respuesta: ${response.code()} - ${response.message()}"
                )

                emptyList()
            }

        } catch (e: Exception) {
            Log.e("MovieRepository", "Error desconocido: ${e.message}")
            throw Exception("Error desconocido: ${e.message}")
        }
    }


}




