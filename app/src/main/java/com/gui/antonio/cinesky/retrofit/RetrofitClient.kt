package com.gui.antonio.cinesky.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient { val client = Retrofit.Builder().baseUrl("https://sky-exercise.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build().create(MoviesService::class.java) }