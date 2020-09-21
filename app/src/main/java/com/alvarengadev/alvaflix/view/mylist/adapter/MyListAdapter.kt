package com.alvarengadev.alvaflix.view.mylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener

class MyListAdapter : RecyclerView.Adapter<MyListViewHolder>() {

    private lateinit var movieOnClickListener: MovieOnClickListener

    fun setOnClickListener(movieOnClickListener: MovieOnClickListener) {
        this.movieOnClickListener = movieOnClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_movies, parent, false)
        return MyListViewHolder(view, movieOnClickListener)
    }

    override fun onBindViewHolder(
        holder: MyListViewHolder,
        position: Int
    ) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }
}