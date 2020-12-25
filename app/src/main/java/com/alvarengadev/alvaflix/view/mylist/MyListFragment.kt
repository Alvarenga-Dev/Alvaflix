package com.alvarengadev.alvaflix.view.mylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.database.AlvaflixDatabase
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.data.repository.DatabaseDataSourceRepository
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.alvarengadev.alvaflix.view.mylist.adapter.MyListAdapter
import kotlinx.android.synthetic.main.fragment_my_list.*

class MyListFragment : Fragment() {

    private val viewModel: MyListViewModel by activityViewModels(
        factoryProducer = {
            val database = AlvaflixDatabase.getInstance(requireContext())
            MyListViewModelFactory(
                databaseDataSourceRepository = DatabaseDataSourceRepository(database.movieFavoritesDao)
            )
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ib_my_list_back.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.getAllMovieFavorites()
        viewModel.listMovieFavorites.observe(viewLifecycleOwner, { listMovieFavorites ->
            val myListAdapter = MyListAdapter(listMovieFavorites)

            myListAdapter.setOnClickListener(object : MovieOnClickListener {
                override fun onItemClick(movie: Movie) {
                    val directions = MyListFragmentDirections.actionMyListFragmentToDetailsFragment(movie)
                    findNavController().navigate(directions)
                }
            })

            rcy_my_list_favorites.apply {
                adapter = myListAdapter
                layoutManager = GridLayoutManager(context, 3)
            }
        })
    }

}