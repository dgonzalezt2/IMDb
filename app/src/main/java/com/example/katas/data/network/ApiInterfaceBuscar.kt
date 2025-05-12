package com.example.katas.data.network



import com.example.katas.data.model.remote.responses.MoviesResponseSearch
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaceBuscar {
@GET("top_rated?api_key=c5c47722a4adcc77f6e84f28a48b857a")
  suspend  fun   getMovies(): Response<MoviesResponseSearch>
}

