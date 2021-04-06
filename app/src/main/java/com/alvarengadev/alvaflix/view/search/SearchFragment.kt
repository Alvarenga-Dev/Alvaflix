package com.alvarengadev.alvaflix.view.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.databinding.FragmentSearchBinding
import com.alvarengadev.alvaflix.utils.toLowerCase
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.alvarengadev.alvaflix.view.search.adapter.SearchAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModel()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val searchBinding = FragmentSearchBinding.bind(view)

        initComponents(searchBinding)
    }

    private fun initComponents(searchBinding: FragmentSearchBinding) {
        searchBinding.textInputSearch.editText?.addTextChangedListener { editable ->
            viewModel.search(toLowerCase(editable.toString()))
        }
        viewModel.listSearch.observe(viewLifecycleOwner, { listSearch ->
            if (listSearch != null) {
                val searchAdapter = SearchAdapter(listSearch)
                searchBinding.rcySearchResults.apply {
                    adapter = searchAdapter
                    layoutManager = LinearLayoutManager(context)
                }

                showSearch(searchBinding)

                searchAdapter.setOnClickListener(object : MovieOnClickListener {
                    override fun onItemClick(movie: Movie) {
                        val directions =
                            SearchFragmentDirections.actionSearchFragmentToDetailsFragment(movie)
                        findNavController().navigate(directions)
                    }
                })
            } else {
                hideSearch(searchBinding)
            }
        })
    }

    private fun showSearch(searchBinding: FragmentSearchBinding) {
        searchBinding.rcySearchResults.visibility = View.VISIBLE
        searchBinding.tvSearchTitleResults.visibility = View.VISIBLE
        searchBinding.tvSearchNotingFound.visibility = View.GONE
    }

    private fun hideSearch(searchBinding: FragmentSearchBinding) {
        searchBinding.rcySearchResults.visibility = View.GONE
        searchBinding.tvSearchTitleResults.visibility = View.GONE
        searchBinding.tvSearchNotingFound.visibility = View.VISIBLE

    }
}