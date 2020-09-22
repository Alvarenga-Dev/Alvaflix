package com.alvarengadev.alvaflix.data.api.network

import com.alvarengadev.alvaflix.data.api.network.popular.MoviePopularService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun movieService() : MoviePopularService = retrofit.create(MoviePopularService::class.java)
}