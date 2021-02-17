package com.alvarengadev.alvaflix.view.home.adapter.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

class MoviesPopularAdapter(
    private val listMoviePopular: ArrayList<Movie>
) : RecyclerView.Adapter<MoviesPopularViewHolder>() {

    private lateinit var movieOnClickListener: MovieOnClickListener

    fun setMovieOnClickListener(
        movieOnClickListener: MovieOnClickListener
    ) {
        this.movieOnClickListener = movieOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesPopularViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list_horizontal_movies, parent, false)

        return MoviesPopularViewHolder(view, movieOnClickListener, listMoviePopular)
    }

    override fun onBindViewHolder(
        holder: MoviesPopularViewHolder,
        position: Int
    ) {
        holder.bind(listMoviePopular[position])
    }

    override fun getItemCount(): Int {
        return listMoviePopular.size
    }

}