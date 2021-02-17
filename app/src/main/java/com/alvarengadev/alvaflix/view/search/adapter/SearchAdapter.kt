package com.alvarengadev.alvaflix.view.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

class SearchAdapter(
    private val listMoviesSearch: ArrayList<Movie>?
) : RecyclerView.Adapter<SearchViewHolder>() {

    private var movieOnClickListener: MovieOnClickListener? = null

    fun setOnClickListener(movieOnClickListener: MovieOnClickListener) {
        this.movieOnClickListener = movieOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_search_movies,
                parent,
                false
            )
        return SearchViewHolder(view, movieOnClickListener, listMoviesSearch)
    }

    override fun onBindViewHolder(
        holder: SearchViewHolder,
        position: Int
    ) {
        holder.bind(listMoviesSearch?.get(position))
    }

    override fun getItemCount(): Int {
        return listMoviesSearch?.size ?: 0
    }
}