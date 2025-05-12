package com.example.katas.data.repository

import android.util.Log
import com.example.katas.data.mappers.toDomainModelList
import com.example.katas.data.network.ApiInterfaceBuscar
import com.example.katas.domain.model.MovieSearch
import com.example.katas.domain.repository.MovieRepositorySearch


import javax.inject.Inject

class MovieRepositorySearchImpl @Inject constructor(private val apiService: ApiInterfaceBuscar) :
    MovieRepositorySearch {
    override suspend fun getMovies(): List<MovieSearch> {
        return try{
            val response = apiService.getMovies()
            if (response.isSuccessful) {
                response.body()?.results?.toDomainModelList()!!
            } else {
                throw Exception("Error en la respuesta: ${response.code()} - ${response.message()}")

            }
        }catch (e: Exception){
            Log.e("MovieRepository", "Error desconocido: ${e.message}")
            throw Exception("Error desconocido: ${e.message}")
        }
    }
}