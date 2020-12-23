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
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.alvarengadev.alvaflix.view.mylist.adapter.MyListAdapter
import kotlinx.android.synthetic.main.fragment_my_list.*

class MyListFragment : Fragment() {

    private val viewModel: MyListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myListAdapter = MyListAdapter()
        myListAdapter.setOnClickListener(object : MovieOnClickListener {
            override fun onItemClick(movie: Movie) {
                findNavController().navigate(R.id.action_myListFragment_to_detailsFragment)
            }
       })

        rcy_my_list_favorites.apply {
            adapter = myListAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

}