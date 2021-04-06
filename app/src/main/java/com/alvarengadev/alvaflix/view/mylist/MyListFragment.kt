package com.alvarengadev.alvaflix.view.mylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.databinding.FragmentMyListBinding
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.alvarengadev.alvaflix.view.mylist.adapter.MyListAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MyListFragment : Fragment(R.layout.fragment_my_list) {

    private val viewModel: MyListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myListBinding = FragmentMyListBinding.bind(view)

        initComponents(myListBinding)
    }

    private fun initComponents(myListBinding: FragmentMyListBinding) {
        myListBinding.ibMyListBack.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.listMovieFavorites.observe(viewLifecycleOwner, { listMovieFavorites ->
            if (listMovieFavorites != null && listMovieFavorites.size > 0) {
                val myListAdapter = MyListAdapter(listMovieFavorites)

                myListAdapter.setOnClickListener(object : MovieOnClickListener {
                    override fun onItemClick(movie: Movie) {
                        val directions =
                            MyListFragmentDirections.actionMyListFragmentToDetailsFragment(movie)
                        findNavController().navigate(directions)
                    }
                })

                myListBinding.rcyMyListFavorites.visibility = View.VISIBLE
                myListBinding.containerStarted.visibility = View.GONE

                myListBinding.rcyMyListFavorites.apply {
                    adapter = myListAdapter
                    layoutManager = GridLayoutManager(context, 3)
                }
            } else {
                myListBinding.rcyMyListFavorites.visibility = View.GONE
                myListBinding.containerStarted.visibility = View.VISIBLE
            }
        })
    }

}