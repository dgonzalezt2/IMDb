package com.example.katas.presentation.search.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katas.data.model.entities.MovieDetalleDto
import com.example.katas.data.network.ApiInterfaceDetalle
import com.example.katas.data.network.ApiService
import com.example.katas.domain.model.MovieDetalle
import com.example.katas.domain.usecase.GetMovieDetailUseCase
import com.example.katas.domain.usecase.GetMovieRecomendationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetalleViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val apiService: ApiInterfaceDetalle,
    private val getMovieRecomendationsUseCase: GetMovieRecomendationsUseCase
) : ViewModel() {

    private val _recommendations = MutableLiveData<List<MovieDetalle>>()
    val recommendations: LiveData<List<MovieDetalle>> get() = _recommendations
    private val _movieDetails = MutableLiveData<MovieDetalle?>()
    val movieDetails: LiveData<MovieDetalle?> get() = _movieDetails

    fun fetchRecommendations(movieId: Int) {
        viewModelScope.launch {
            try {
                val recommendationsList = getMovieRecomendationsUseCase.execute(movieId)

                Log.d("DetalleViewModel", "Recomendaciones obtenidas: $recommendationsList")
                _recommendations.postValue(recommendationsList)
            } catch (e: IOException) {

                Log.e("DetalleViewModel", "Error de red: ${e.message}")

            } catch (e: HttpException) {
                Log.e("DetalleViewModel", "Error HTTP: ${e.message()}")
            } catch (e: Exception) {
                Log.e("DetalleViewModel", "Error desconocido: ${e.message}")
            }
        }
    }
    fun fetchMovieDetails(movieId: Int) {
        viewModelScope.launch {
            try {
                val movieDetail = getMovieDetailUseCase.execute(movieId)
                _movieDetails.postValue(movieDetail)
                Log.d("DetalleViewModel", "Detalles de la película obtenidos: $movieDetail")

            } catch (e: Exception) {
                Log.e("DetalleViewModel", "Error al obtener detalles de la película: ${e.message}")

            }


        }
    }
}

