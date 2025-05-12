package com.example.katas.presentation.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katas.data.model.entities.MovieTopRatedAndPopularDto
import com.example.katas.data.network.ApiConstants
import com.example.katas.databinding.ItemsMoviesInicioBinding

class MoviesViewHolderTopRatedAndPopular(view: View): RecyclerView.ViewHolder(view){
    private val binding = ItemsMoviesInicioBinding.bind(view)

    fun render(MoviesModel2: MovieTopRatedAndPopularDto) {
        binding.textTitleRating.text = MoviesModel2.title
        binding.textRating.text = MoviesModel2.rating

        val imageURL =   ApiConstants.IMAGE_URL   + "w500" +  MoviesModel2.posterPath

        Glide.with(binding.moviePoster.context)
            .load(imageURL)
            .into(binding.moviePoster)





    }
}