package com.example.katas.di

import com.example.katas.data.repository.MovieRepositoryDetailsAndRecommendationsImpl
import com.example.katas.data.repository.MovieRepositorySearchImpl
import com.example.katas.domain.repository.MovieRepositoryDetailsAndRecommendations
import com.example.katas.domain.repository.MovieRepositorySearch
import com.example.katas.domain.usecase.GetMovieDetailUseCase
import com.example.katas.domain.usecase.GetMovieDetailUseCaseImpl
import com.example.katas.domain.usecase.GetMovieRecomendationsUseCase
import com.example.katas.domain.usecase.GetMovieRecomendationsUseCaseImpl
import com.example.katas.domain.usecase.GetMovieSearchUseCase
import com.example.katas.domain.usecase.GetMovieSearchUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 abstract class AppModule {

     // Binds para vincular la implementación a la interfaz abstracta (MovieRepository)
     // comenzamos con el modulo para los detalles y las recomendaciones de la pelicula
     @Binds
     abstract  fun bindMovieRepositoryDetailsAndRecommendations(impl: MovieRepositoryDetailsAndRecommendationsImpl): MovieRepositoryDetailsAndRecommendations

     @Binds
     abstract  fun bindGetMovieDetailUsecase(impl: GetMovieDetailUseCaseImpl):GetMovieDetailUseCase

     @Binds
     abstract fun bindGetMovieRecomendationsUsecase(impl: GetMovieRecomendationsUseCaseImpl):GetMovieRecomendationsUseCase
     // aqui cerramos el modulo para los detalles y las recomendaciones de la pelicula y sus implementaciones

     // comenzamos con el modulo para buscar la pelicula


     @Binds
     abstract  fun bindMovieRepositorySearch(impl: MovieRepositorySearchImpl): MovieRepositorySearch

     @Binds
     abstract  fun bindGetMovieSearchUsecase(impl: GetMovieSearchUseCaseImpl): GetMovieSearchUseCase

     // aqui cerramos el modulo para buscar la pelicula



}