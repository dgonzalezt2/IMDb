package com.example.katas.data.model.entities

import com.google.gson.annotations.SerializedName

data class MovieTopRatedAndPopularDto(
    val id: Int,
    val title: String?,
    @SerializedName("vote_average")
    val rating: String?,
    @SerializedName("poster_path")
    val posterPath: String?,


    )