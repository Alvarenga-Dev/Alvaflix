package com.alvarengadev.alvaflix.view.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.extensions.layoutHorizontal
import com.alvarengadev.alvaflix.view.home.adapter.popular.MoviesPopularAdapter
import com.alvarengadev.alvaflix.view.home.adapter.recommend.MoviesRecommendAdapter
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        initRcyPopular()
        initRcyRecommends()
        initButtonMyList()
    }

    private fun initButtonMyList() {
        btn_home_my_list.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_myListFragment)
        }
    }

    private fun initRcyPopular() {
        viewModel.listMoviePopularData.observe(viewLifecycleOwner, { moviesPopular ->
            val popularMoviesAdapter = MoviesPopularAdapter(moviesPopular)

            popularMoviesAdapter.setMovieOnClickListener(object : MovieOnClickListener {
                override fun onItemClick() {
                    findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
                }
            })
            rcy_home_popular_movies.apply {
                adapter = popularMoviesAdapter
                layoutManager = this.layoutHorizontal()
            }
        })
        viewModel.getListMoviePopular()
   }

    private fun initRcyRecommends() {
        viewModel.listMovieRecommendData.observe(viewLifecycleOwner, { movieRecommend ->
            val movieRecommendAdapter = MoviesRecommendAdapter(movieRecommend)

            movieRecommendAdapter.setRecommendOnClickListener(object : MovieOnClickListener {
                override fun onItemClick() {
                    findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
                }
            })

            rcy_recommend_movies.apply {
                adapter = movieRecommendAdapter
                layoutManager = this.layoutHorizontal()
            }
        })
        viewModel.getListMovieRecommend()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

}