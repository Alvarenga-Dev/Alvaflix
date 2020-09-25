package com.alvarengadev.alvaflix.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alvarengadev.alvaflix.data.api.mapper.MoviePopularMapper
import com.alvarengadev.alvaflix.data.api.network.RetrofitInitializer
import com.alvarengadev.alvaflix.data.api.network.popular.response.MoviePopularResult
import com.alvarengadev.alvaflix.data.domain.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDataSourceRepository(
    private val liveData: MutableLiveData<ArrayList<Movie>>
) : Callback<MoviePopularResult> {

    fun callRetrofitApi() =
        RetrofitInitializer().movieService().list().enqueue(this)

    override fun onResponse(
        call: Call<MoviePopularResult>,
        response: Response<MoviePopularResult>
    ) {
        if (response.isSuccessful) {
            response.body()?.let { moviePopularResult ->
                liveData.value = MoviePopularMapper.responseToDomain(moviePopularResult.results)
            }
        }
    }

    override fun onFailure(
        call: Call<MoviePopularResult>,
        t: Throwable
    ) {
        Log.i("AAAAAAAA", t.message.toString())
    }

}