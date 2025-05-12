package com.example.katas.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.katas.data.model.local.dao.MovieDao

class MoviesViewModelFactory(private val movieDao: MovieDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MoviesViewModel::class.java)){
            return  MoviesViewModel(movieDao) as T
        }
        throw IllegalArgumentException("No se encontro el viewmodel ")
    }
}