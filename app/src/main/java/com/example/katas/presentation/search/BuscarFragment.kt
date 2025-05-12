package com.example.katas.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.R

import com.example.katas.databinding.FragmentMoviesBinding
import com.example.katas.domain.model.MovieSearch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuscarFragment : Fragment(R.layout.fragment_movies) {


    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    lateinit var  adapter : MoviesAdapterSearch
    lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        initRecyclerVIew()


        // observa los cambios  en la lista de peliculas
        configuredobservers()
        // poner visible  el progressbar

        loadconfigurationfortheview()


        moviesfiltered()
    }

    private fun loadconfigurationfortheview() {
        searchViewModel.loadMovies()
    }

    private fun configuredobservers() {
        searchViewModel.movies.observe(viewLifecycleOwner) { movies ->
            // hide el progress bar
            if (movies.isNotEmpty()) {
                adapter.updateList(movies)
            }
        }

        searchViewModel.filteredMovies.observe(viewLifecycleOwner) { filteredMovies ->
            adapter.updateList(filteredMovies)
        }
    }


    fun initRecyclerVIew() {
        val manager = LinearLayoutManager(requireContext())
        adapter  = MoviesAdapterSearch{movie -> onMovieClick(movie)}
        binding.movieRecycler.layoutManager = manager
        binding.movieRecycler.adapter = adapter
    }


    fun onMovieClick(movie: MovieSearch) {
        movie.id?.let { movieId ->
            val action = BuscarFragmentDirections.actionPageBuscarToPageDetail(movieId)
            findNavController().navigate(action)
            Log.d("BuscarFragment", "Navegando a DetalleFragment con movieId: $movieId")
        } ?:run{
            Toast.makeText(requireContext(), "hola", Toast.LENGTH_SHORT).show()


        }
    }
    fun moviesfiltered(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {searchViewModel.filterMovies(it)}
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {searchViewModel.filterMovies(it)}
                return true
            }



        })

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


} // del oncreate
