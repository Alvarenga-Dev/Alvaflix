package com.alvarengadev.alvaflix.view.details.adapter.similar

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.squareup.picasso.Picasso

class MovieSimilarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(movieSimilar: Movie) {
        val ivPoster = itemView.findViewById(R.id.iv_movie_poster) as ImageView
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${movieSimilar.poster}")
            .into(ivPoster)
    }
}