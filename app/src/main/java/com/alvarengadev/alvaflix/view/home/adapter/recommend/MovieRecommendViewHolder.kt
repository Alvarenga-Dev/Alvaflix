package com.alvarengadev.alvaflix.view.home.adapter.recommend

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.squareup.picasso.Picasso

class MovieRecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movieRecommend: Movie) {
        val ivPoster = itemView.findViewById(R.id.iv_movie_poster) as ImageView
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${movieRecommend.poster}")
            .into(ivPoster)
    }
}