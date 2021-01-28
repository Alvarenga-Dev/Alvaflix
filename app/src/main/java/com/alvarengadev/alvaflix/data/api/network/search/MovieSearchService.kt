package com.alvarengadev.alvaflix.data.api.network.search

import com.alvarengadev.alvaflix.data.api.network.search.response.MovieSearchResult
import com.alvarengadev.alvaflix.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieSearchService {

    @GET("search/movie")
    fun search(
        @Query("query") searchMovie: String,
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<MovieSearchResult>
}