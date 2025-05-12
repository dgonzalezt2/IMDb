package com.example.katas.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.katas.data.model.entities.MovieTopRatedAndPopularDto
import com.example.katas.data.model.local.dao.MovieDao
import com.example.katas.data.model.local.entity.MovieEntity
import com.example.katas.data.network.ApiInterfaceTopRatingAndPopular
import com.example.katas.data.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(private  val movieDao: MovieDao) : ViewModel() {

    private var _moviesRated = MutableLiveData<List<MovieTopRatedAndPopularDto>>()
    val moviesRated: LiveData<List<MovieTopRatedAndPopularDto>> = _moviesRated
    private var _moviesPopular = MutableLiveData<List<MovieTopRatedAndPopularDto>>()
    var moviesPopular: LiveData<List<MovieTopRatedAndPopularDto>> = _moviesPopular



    fun loadMoviesRated() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiservice =
                ApiService.getInstance().create(ApiInterfaceTopRatingAndPopular::class.java)
            try {
                val response = apiservice.getTopRatedMovies()
                if (response.isSuccessful && response.body() != null) {
                    val movieRating = response.body()!!.results
                    withContext(Dispatchers.Main) {
                        _moviesRated.value = movieRating
                    }

                }
            } catch (e: Exception) {
            }
        }
    }

    fun loadMoviesPopular() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiService =
                ApiService.getInstance().create(ApiInterfaceTopRatingAndPopular::class.java)
            try {
                val response = apiService.getPopularMovies()
                if (response.isSuccessful && response.body() != null) {
                    val moviePopular = response.body()!!.results

                    // guardar en room
                    saveMoviesToRoom(moviePopular)
                    withContext(Dispatchers.Main) {
                        _moviesPopular.value = moviePopular
                    }


                }
            } catch (e: Exception) {
            }
        }
    }

    private suspend fun saveMoviesToRoom(movies: List<MovieTopRatedAndPopularDto>){

        val moviesToSave = movies.map {  movie ->
            MovieEntity(
                id = movie.id,
                title = movie.title,
                rating = movie.rating,
                posterPath = movie.posterPath

            )
        }
        movieDao.movieInsertAll(moviesToSave)

    }

    fun loadMoviesFromRoom(){
        CoroutineScope(Dispatchers.IO).launch {
            val moviesFromRoom = movieDao.getAllMovies()
            withContext(Dispatchers.Main){
                _moviesRated.value = moviesFromRoom.map {entity ->
                    MovieTopRatedAndPopularDto(
                        id = entity.id,
                        title = entity.title,
                        rating = entity.rating,
                        posterPath = entity.posterPath
                    )
                }
                _moviesPopular.value = moviesFromRoom.map {entity ->
                    MovieTopRatedAndPopularDto(
                        id = entity.id,
                        title = entity.title,
                        rating = entity.rating,
                        posterPath = entity.posterPath
                    )
                }
            }
        }
    }


}


