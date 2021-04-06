package com.alvarengadev.alvaflix.data

import com.alvarengadev.alvaflix.data.domain.Movie

class MoviesDataSourceFake {
    fun getListDataFakes(arrayMovies: ArrayList<Movie>): ArrayList<Movie> {
        arrayMovies.add(
            Movie(
                10,
                "Title 1",
                "Poster Simple 1",
                "Poster Details 1",
                "Description 1",
                "5.0",
                "05/04/2021"
            )
        )
        return arrayMovies
    }
}