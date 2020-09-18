package com.alvarengadev.alvaflix.view.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.view.home.adapter.popular.PopularMoviesAdapter
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

        initRecyclerViews()
    }

    private fun initRecyclerViews() {

        val layoutManagerHorizontal = LinearLayoutManager(context)
        layoutManagerHorizontal.orientation = LinearLayoutManager.HORIZONTAL

        val popularMoviesAdapter = PopularMoviesAdapter()
        popularMoviesAdapter.setMovieOnClickListener(object : MovieOnClickListener {
            override fun onItemClick() {
                findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
            }
        })

        rcy_home_popular_movies.apply {
            adapter = popularMoviesAdapter
            layoutManager = layoutManagerHorizontal
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

}