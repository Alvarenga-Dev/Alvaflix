package com.alvarengadev.alvaflix.view.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.utils.toLowerCase
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.alvarengadev.alvaflix.view.search.adapter.SearchAdapter
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        text_input_search.editText?.addTextChangedListener { editable ->
            viewModel.search(toLowerCase(editable.toString()))
        }
        viewModel.listSearch.observe(viewLifecycleOwner, { listSearch ->
            if (listSearch != null) {
                val searchAdapter = SearchAdapter(listSearch)
                rcy_search_results.apply {
                    adapter = searchAdapter
                    layoutManager = LinearLayoutManager(context)
                }

                showSearch()

                searchAdapter.setOnClickListener(object : MovieOnClickListener {
                    override fun onItemClick(movie: Movie) {
                        val directions = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(movie)
                        findNavController().navigate(directions)
                    }
                })
            } else {
                hideSearch()
            }
        })
    }

    private fun showSearch() {
        rcy_search_results.visibility = View.VISIBLE
        tv_search_title_results.visibility = View.VISIBLE
        tv_search_noting_found.visibility = View.GONE
    }

    private fun hideSearch() {
        rcy_search_results.visibility = View.GONE
        tv_search_title_results.visibility = View.GONE
        tv_search_noting_found.visibility = View.VISIBLE

    }
}