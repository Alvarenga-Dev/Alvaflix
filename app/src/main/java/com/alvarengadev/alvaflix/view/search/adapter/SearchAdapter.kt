package com.alvarengadev.alvaflix.view.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie

class SearchAdapter(
    private val listMovieSearch: ArrayList<Movie>
) : RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_search_movies,
                parent,
                false
            )

        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listMovieSearch[position])
    }

    override fun getItemCount(): Int {
        return listMovieSearch.size
    }
}