package com.gui.antonio.cinesky.repository

import androidx.lifecycle.LiveData
import com.gui.antonio.cinesky.data.Movies

interface IRepository {

    fun getMovies() : LiveData<List<Movies>>
    fun getMoviesOffline() : LiveData<List<Movies>>
    val getMoviesError : LiveData<Throwable>
    fun getMovie(title:String) : LiveData<Movies>



}