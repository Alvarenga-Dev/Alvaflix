package com.alvarengadev.alvaflix.view.details.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.squareup.picasso.Picasso

class MovieSimilarViewHolder(
    itemView: View,
    onClickListener: MovieOnClickListener,
    listMoviesSimilar: ArrayList<Movie>
) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val positionRcy = adapterPosition
            if (positionRcy != RecyclerView.NO_POSITION) {
                onClickListener.onItemClick(listMoviesSimilar[positionRcy])
            }
        }
    }

    fun bind(movieSimilar: Movie) {
        val ivPoster = itemView.findViewById(R.id.iv_movie_poster) as ImageView
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${movieSimilar.poster}")
            .into(ivPoster)
    }
}