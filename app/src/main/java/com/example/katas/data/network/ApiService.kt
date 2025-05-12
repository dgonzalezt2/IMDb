package com.example.katas.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/movie/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/"
        private var retrofit: Retrofit? = null


        fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()

            }
            return retrofit!!
        }

    }
}
