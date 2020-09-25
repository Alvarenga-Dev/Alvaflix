package com.alvarengadev.alvaflix.view.home.adapter.recommend

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.squareup.picasso.Picasso

class MoviesRecommendViewHolder(
    itemView: View,
    onClickListener: MovieOnClickListener,
    listMovieRecommend: ArrayList<Movie>
) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val positionRcy = adapterPosition
            if (positionRcy != RecyclerView.NO_POSITION) {
                onClickListener.onItemClick()
            }
        }
    }

    fun bind(movieRecommend: Movie) {
        val ivPoster = itemView.findViewById(R.id.iv_movie_poster) as ImageView
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${movieRecommend.poster}")
            .into(ivPoster)
    }
}