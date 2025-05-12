package com.example.katas.data.model.entities

import com.google.gson.annotations.SerializedName

data class MovieSearchDto(
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,

)