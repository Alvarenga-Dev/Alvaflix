package com.alvarengadev.alvaflix.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alvarengadev.alvaflix.data.api.mapper.MoviePopularMapper
import com.alvarengadev.alvaflix.data.api.mapper.MovieRecommendMapper
import com.alvarengadev.alvaflix.data.api.network.RetrofitInitializer
import com.alvarengadev.alvaflix.data.api.network.popular.response.MoviePopularResult
import com.alvarengadev.alvaflix.data.api.network.recommend.response.MovieRecommendResult
import com.alvarengadev.alvaflix.data.domain.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDataSourceRepository {

    fun callRetrofitApi(liveData: MutableLiveData<ArrayList<Movie>>) {
        RetrofitInitializer().movieService().list().enqueue(object : Callback<MoviePopularResult> {
            override fun onResponse(
                call: Call<MoviePopularResult>,
                response: Response<MoviePopularResult>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { moviePopularResult ->
                        liveData.value =
                            MoviePopularMapper.responseToDomain(moviePopularResult.results)
                    }
                }
            }

            override fun onFailure(
                call: Call<MoviePopularResult>,
                t: Throwable
            ) {
                Log.i("Error", t.message.toString())
            }
        })
    }

    fun callMoviesRecommends(listRecommends: MutableLiveData<ArrayList<Movie>>) {
        RetrofitInitializer().movieRecommendService().list()
            .enqueue(object : Callback<MovieRecommendResult> {
                override fun onResponse(
                    call: Call<MovieRecommendResult>,
                    response: Response<MovieRecommendResult>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { movieRecommendResult ->
                            listRecommends.value = MovieRecommendMapper.responseToDomain(movieRecommendResult.results)
                        }
                    }
                }

                override fun onFailure(call: Call<MovieRecommendResult>, t: Throwable) {
                    Log.i("Error", t.message.toString())
                }

            })
    }

}