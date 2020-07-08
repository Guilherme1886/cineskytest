package com.gui.antonio.cinesky.retrofit

import com.gui.antonio.cinesky.data.Movies
import retrofit2.Call
import retrofit2.http.GET

interface MoviesService {

    @GET("/api/Movies")
    fun getMovies(): Call<List<Movies>>

}