package com.alvarengadev.alvaflix.view.search.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.utils.FormatDate
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.squareup.picasso.Picasso

class SearchViewHolder(
    itemView: View,
    onClickListener: MovieOnClickListener?,
    listMovieSearch: ArrayList<Movie>?
) : RecyclerView.ViewHolder(itemView) {

    init {
        if (listMovieSearch != null) {
            itemView.setOnClickListener {
                val positionRcy = adapterPosition
                if (positionRcy != RecyclerView.NO_POSITION) {
                    onClickListener?.onItemClick(listMovieSearch[positionRcy])
                }
            }
        }
    }

    fun bind(searchMovie: Movie?) {
        val ivPoster = itemView.findViewById(R.id.iv_movie_poster_search) as ImageView
        val tvTitle = itemView.findViewById(R.id.tv_title_movie_search) as TextView
        val tvDescription = itemView.findViewById(R.id.tv_description_movie_search) as TextView
        val tvRelease = itemView.findViewById(R.id.tv_release_movie_search) as TextView

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${searchMovie?.poster}")
            .into(ivPoster)

        tvTitle.text = searchMovie?.title
        tvDescription.text = searchMovie?.description
        tvRelease.text = searchMovie?.date?.let { date ->
            FormatDate.getMediumDate(date)
        }
    }
}