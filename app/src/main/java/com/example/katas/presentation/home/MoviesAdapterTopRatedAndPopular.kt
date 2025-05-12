package com.example.katas.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katas.R

import com.example.katas.data.model.entities.MovieTopRatedAndPopularDto

class MoviesAdapterTopRatedAndPopular(private val MoviesList2: List<MovieTopRatedAndPopularDto>) :
    RecyclerView.Adapter<MoviesViewHolderTopRatedAndPopular>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolderTopRatedAndPopular {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolderTopRatedAndPopular(
            layoutInflater.inflate(
                R.layout.items_movies_inicio,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = MoviesList2.size


    override fun onBindViewHolder(holder: MoviesViewHolderTopRatedAndPopular, position: Int) {
        holder.render(MoviesList2[position])

    }

}