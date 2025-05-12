package com.example.katas.data.model.entities

import com.google.gson.annotations.SerializedName


data class MovieDetalleDto(
    val id: Int?,
    @SerializedName("vote_average")
    val rating: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val title: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    val overview: String?,
    val genres: List<GeneroDto>



)






