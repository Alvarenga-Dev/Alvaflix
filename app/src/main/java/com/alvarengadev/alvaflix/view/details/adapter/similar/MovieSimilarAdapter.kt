package com.alvarengadev.alvaflix.view.details.adapter.similar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie

class MovieSimilarAdapter(
    private val listMovieSimilar: ArrayList<Movie>
    ) : RecyclerView.Adapter<MovieSimilarViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieSimilarViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_movies, parent, false)

        return MovieSimilarViewHolder(view)
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