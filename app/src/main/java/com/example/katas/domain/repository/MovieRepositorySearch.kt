package com.example.katas.domain.repository

import com.example.katas.domain.model.MovieSearch

interface MovieRepositorySearch {
suspend fun  getMovies(): List<MovieSearch>
}