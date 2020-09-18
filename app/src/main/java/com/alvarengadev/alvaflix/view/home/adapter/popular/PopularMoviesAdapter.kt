package com.alvarengadev.alvaflix.view.home.adapter.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

class PopularMoviesAdapter() : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    private lateinit var movieOnClickListener: MovieOnClickListener

    fun setMovieOnClickListener(
        movieOnClickListener: MovieOnClickListener
    ) {
        this.movieOnClickListener = movieOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMoviesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_movies_horizontal, parent, false)

        return PopularMoviesViewHolder(view, movieOnClickListener)
    }

    override fun onBindViewHolder(
        holder: PopularMoviesViewHolder,
        position: Int
    ) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }

}