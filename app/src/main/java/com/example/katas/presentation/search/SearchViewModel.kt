package com.example.katas.presentation.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katas.domain.model.MovieSearch
import com.example.katas.domain.usecase.GetMovieSearchUseCase
import com.example.katas.data.network.ApiInterfaceBuscar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getMovieSearchUseCase: GetMovieSearchUseCase,
    private val apiService: ApiInterfaceBuscar

) : ViewModel() {
    private val _movies = MutableLiveData<List<MovieSearch>>()
    val movies: LiveData<List<MovieSearch>> = _movies
    private var _filteredMovies = MutableLiveData<List<MovieSearch>>()
    val filteredMovies: LiveData<List<MovieSearch>> = _filteredMovies
    private var originalMovieList: List<MovieSearch> = emptyList()

    fun loadMovies() {
        viewModelScope.launch {
            try{
                val moviesList = getMovieSearchUseCase.execute()
                _movies.value = moviesList
                _filteredMovies.value = moviesList
                originalMovieList = moviesList
            }catch (e: Exception){
                Log.e("SearchViewModel", "Error al cargar películas: ${e.message}")

            }
        }


    }

    fun filterMovies(title: String) {
        val filteredList = originalMovieList.filter {
            it.title?.lowercase(Locale.getDefault())
                ?.contains(title.lowercase(Locale.getDefault())) == true

        }
        _filteredMovies.value = filteredList
    }
}
