package com.alvarengadev.alvaflix.view.mylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.data.domain.Movie
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

class MyListAdapter(
    private val listMovieFavorites: ArrayList<Movie>
) : RecyclerView.Adapter<MyListViewHolder>() {

    private lateinit var movieOnClickListener: MovieOnClickListener

    fun setOnClickListener(movieOnClickListener: MovieOnClickListener) {
        this.movieOnClickListener = movieOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_movies, parent, false)
        return MyListViewHolder(view, movieOnClickListener, listMovieFavorites)
    }

    override fun onBindViewHolder(
        holder: MyListViewHolder,
        position: Int
    ) {
        holder.bind(listMovieFavorites[position])
    }

    override fun getItemCount(): Int {
        return listMovieFavorites.size
    }
}