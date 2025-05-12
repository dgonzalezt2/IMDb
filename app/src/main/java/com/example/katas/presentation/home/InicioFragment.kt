package com.example.katas.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.R
import com.example.katas.data.model.entities.MovieTopRatedAndPopularDto
import com.example.katas.data.model.local.AppDatabase
import com.example.katas.databinding.FragmentInicioBinding

class InicioFragment : Fragment(R.layout.fragment_inicio) {
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!
    private lateinit var  moviesViewModel : MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieDao = AppDatabase.getDatabase(requireContext()).MovieDao()
        val factory = MoviesViewModelFactory(movieDao)

        moviesViewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

        moviesViewModel = ViewModelProvider(this)[MoviesViewModel::class.java]

        moviesViewModel.moviesPopular.observe(viewLifecycleOwner){
            moviesPopular -> initPopularRecyclerView(moviesPopular)
        }

        moviesViewModel.moviesRated.observe(viewLifecycleOwner){
            moviesRated -> initRatingRecyclerView(moviesRated)
        }
        moviesViewModel.loadMoviesFromRoom()
        moviesViewModel.loadMoviesPopular()
        moviesViewModel.loadMoviesRated()


    }





    private fun initPopularRecyclerView(movieList: List<MovieTopRatedAndPopularDto>) {

        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPopular.layoutManager = manager


        binding.recyclerViewPopular.adapter = MoviesAdapterTopRatedAndPopular(movieList)
    }


    fun initRatingRecyclerView(movieList: List<MovieTopRatedAndPopularDto>) {

        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewRating.layoutManager = manager


        binding.recyclerViewRating.adapter = MoviesAdapterTopRatedAndPopular(movieList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


