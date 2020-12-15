package com.alvarengadev.alvaflix.view.interfaces

import com.alvarengadev.alvaflix.data.domain.Movie

interface MovieOnClickListener {
    fun onItemClick(movie: Movie)
}