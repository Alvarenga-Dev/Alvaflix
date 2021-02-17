package com.alvarengadev.alvaflix.view.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

class MovieSimilarAdapter(
    private val listMovieSimilar: ArrayList<Movie>
    ) : RecyclerView.Adapter<MovieSimilarViewHolder>() {

    private lateinit var movieOnClickListener: MovieOnClickListener

    fun setOnClickListener(
        movieOnClickListener: MovieOnClickListener
    ) {
        this.movieOnClickListener = movieOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieSimilarViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list_horizontal_movies, parent, false)

        return MovieSimilarViewHolder(view, movieOnClickListener, listMovieSimilar)
    }

    override fun onBindViewHolder(
        holder: MovieSimilarViewHolder,
        position: Int
    ) {
        holder.bind(listMovieSimilar[position])
    }

    override fun getItemCount(): Int {
        return listMovieSimilar.size
    }
}