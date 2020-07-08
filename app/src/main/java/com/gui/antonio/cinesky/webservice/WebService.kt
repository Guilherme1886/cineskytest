package com.gui.antonio.cinesky.webservice

import androidx.lifecycle.MutableLiveData
import com.gui.antonio.cinesky.data.Movies
import com.gui.antonio.cinesky.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebService : IWebService {

    override val getMoviesError = MutableLiveData<Throwable>()

    override fun getMovies(onSuccess: (movies: List<Movies>?) -> Unit) {

        RetrofitClient.client.getMovies().enqueue(object : Callback<List<Movies>> {
            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                getMoviesError.value = t
            }

            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {
                response.let { resultResponse ->
                    if (resultResponse.isSuccessful) {
                        response.body().let { onSuccess(it) }
                    } else {
                        getMoviesError.value = Throwable("noSuccessful")
                    }
                }
            }

        })
    }


}