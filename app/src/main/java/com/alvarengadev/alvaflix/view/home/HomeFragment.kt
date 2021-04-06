package com.alvarengadev.alvaflix.view.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.databinding.FragmentHomeBinding
import com.alvarengadev.alvaflix.extensions.layoutHorizontal
import com.alvarengadev.alvaflix.view.home.adapter.popular.MoviesPopularAdapter
import com.alvarengadev.alvaflix.view.home.adapter.recommend.MoviesRecommendAdapter
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val homeBinding = FragmentHomeBinding.bind(view)

        initRcyPopular(homeBinding)
        initRcyRecommends(homeBinding)
        initButtons(homeBinding)
    }

    private fun initButtons(homeBinding: FragmentHomeBinding) {

        homeBinding.btnHomeMyList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_myListFragment)
        }
        homeBinding.ibSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
    }

    private fun initRcyPopular(homeBinding: FragmentHomeBinding) {
        viewModel.listMoviePopularData.observe(viewLifecycleOwner, { moviesPopular ->
            val popularMoviesAdapter = MoviesPopularAdapter(moviesPopular)

            popularMoviesAdapter.setMovieOnClickListener(object : MovieOnClickListener {
                override fun onItemClick(movie: Movie) {
                    val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movie)
                    findNavController().navigate(direction)
                }
            })
            homeBinding.rcyHomePopularMovies.apply {
                adapter = popularMoviesAdapter
                layoutManager = this.layoutHorizontal()
            }
        })
   }

    private fun initRcyRecommends(homeBinding: FragmentHomeBinding) {
        viewModel.listMovieRecommendData.observe(viewLifecycleOwner, { movieRecommend ->
            val movieRecommendAdapter = MoviesRecommendAdapter(movieRecommend)

            movieRecommendAdapter.setRecommendOnClickListener(object : MovieOnClickListener {
                override fun onItemClick(movie: Movie) {
                    val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movie)
                    findNavController().navigate(direction)
                }
            })

            homeBinding.rcyRecommendMovies.apply {
                adapter = movieRecommendAdapter
                layoutManager = this.layoutHorizontal()
            }
        })
    }
}