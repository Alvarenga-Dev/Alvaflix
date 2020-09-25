package com.alvarengadev.alvaflix.data.api.network.recommend

import com.alvarengadev.alvaflix.data.api.network.recommend.response.MovieRecommendResult
import com.alvarengadev.alvaflix.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRecommendService {
    @GET("movie/top_rated")
    fun list(
        @Query("api_key") apiKey: String = API_KEY
    ) : Call<MovieRecommendResult>
}