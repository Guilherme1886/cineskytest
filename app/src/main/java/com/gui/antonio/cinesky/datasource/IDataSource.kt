package com.gui.antonio.cinesky.datasource

import androidx.lifecycle.LiveData
import com.gui.antonio.cinesky.data.Movies

interface IDataSource {

    fun getMovies() : LiveData<List<Movies>>
    fun getMoviesOffline() : LiveData<List<Movies>>
    fun getMovie(title:String) : LiveData<Movies>
    val getMoviesError : LiveData<Throwable>

}