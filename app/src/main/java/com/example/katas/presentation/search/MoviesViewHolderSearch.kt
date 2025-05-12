package com.example.katas.presentation.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


import com.example.katas.data.model.entities.MovieSearchDto
import com.example.katas.data.network.ApiConstants
import com.example.katas.databinding.ViewMoviesBinding
import com.example.katas.domain.model.MovieSearch

class MoviesViewHolderSearch(view: View,private val clickListener: (MovieSearch)-> Unit):RecyclerView.ViewHolder(view){
    private val binding = ViewMoviesBinding.bind(view)



    fun render(moviesModel: MovieSearch) {
        binding.tvTitle.text = moviesModel.title
        binding.tvYear.text = moviesModel.releaseDate
        binding.tvOverview.text = moviesModel.overview
        val imageURL =   ApiConstants.IMAGE_URL   + "w500" + moviesModel.posterPath

        Glide.with(binding.imageView.context)
            .load(imageURL)
            .into(binding.imageView)

        itemView.setOnClickListener {
            clickListener.invoke(moviesModel)
        }
    }
}

