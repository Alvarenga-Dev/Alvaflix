package com.alvarengadev.alvaflix.view.home.adapter.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

class MoviesRecommendAdapter(
    private val listRecommendMovies: ArrayList<Movie>
) : RecyclerView.Adapter<MoviesRecommendViewHolder>() {

    private lateinit var movieOnClickListener: MovieOnClickListener

    fun setRecommendOnClickListener(movieOnClickListener: MovieOnClickListener) {
        this.movieOnClickListener = movieOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesRecommendViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list_horizontal_movies, parent, false)

        return MoviesRecommendViewHolder(view, movieOnClickListener, listRecommendMovies)
    }

    override fun onBindViewHolder(
        holder: MoviesRecommendViewHolder,
        position: Int
    ) {
        holder.bind(listRecommendMovies[position])
    }

    override fun getItemCount(): Int {
        return listRecommendMovies.size
    }
}