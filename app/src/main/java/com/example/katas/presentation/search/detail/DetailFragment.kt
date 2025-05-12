package com.example.katas.presentation.search.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.katas.R
import com.example.katas.data.network.ApiService.Companion.IMAGE_URL
import com.example.katas.databinding.FragmentDetailBinding

import com.example.katas.domain.model.MovieDetalle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var adapter: MoviesAdapterDetail
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetalleViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val movieId = args.movieId

        adapter = MoviesAdapterDetail(emptyList())
        viewModel.fetchRecommendations(movieId)
        viewModel.fetchMovieDetails(movieId)

        InitRecyclerView()

        viewModel.recommendations.observe(viewLifecycleOwner) { recommendations ->
            recommendations?.let {
            adapter.updateList(recommendations)
            } ?: run { adapter.updateList(emptyList()) }
        }

        viewModel.movieDetails.observe(viewLifecycleOwner) { movieDetail ->
            renderDetails(
                movieDetail
            )
        }
        binding.btnatrasdetalle.setOnClickListener{

            requireActivity().onBackPressed()
        }


    }

    private fun renderDetails(movieDetail: MovieDetalle?) {
        movieDetail?.let {
            binding.textTitleOriginal.text = movieDetail.originalTitle
            binding.textTitleDetalle.text = movieDetail.title
            binding.textTitleOriginalDetalle.text = movieDetail.originalTitle + "(Titulo Original )"
            binding.RatingDetalle.text = movieDetail.rating
            binding.textOverViewDetail.text = movieDetail.overview
            val imageURL = IMAGE_URL + "w500" + movieDetail.posterPath
            val imageURLback = IMAGE_URL + "w500" + movieDetail.backdropPath

            if (movieDetail.genres.isNotEmpty()){
              val   firstGenreName = movieDetail.genres[0].name
                binding.TextGenre.text = firstGenreName
            }else{
                binding.TextGenre.text = "N"
            }

            Glide.with(binding.Portadadetalle.context)
                .load(imageURL)
                .into(binding.Portadadetalle)

            Glide.with(binding.imagePreview.context)
                .load(imageURLback)
                .into(binding.imagePreview)
        }
    }

    private fun InitRecyclerView() {
        binding.recyclerViewRecomendaciones.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewRecomendaciones.adapter = MoviesAdapterDetail(emptyList())
        binding.recyclerViewRecomendaciones.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
