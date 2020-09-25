package com.alvarengadev.alvaflix.view.home.adapter.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie

class MovieRecommendAdapter(
    private val listRecommendMovies: ArrayList<Movie>
) : RecyclerView.Adapter<MovieRecommendViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieRecommendViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_movies, parent, false)

        return MovieRecommendViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MovieRecommendViewHolder,
        position: Int
    ) {
        holder.bind(listRecommendMovies[position])
    }

    override fun getItemCount(): Int {
        return listRecommendMovies.size
    }
}