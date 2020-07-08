package com.gui.antonio.cinesky.viewmodel

import androidx.lifecycle.LiveData
import com.gui.antonio.cinesky.data.Movies

interface IMainViewModel {

    fun getMovies() : LiveData<List<Movies>>
    fun getMoviesOffline() : LiveData<List<Movies>>
    val getMoviesError : LiveData<Throwable>
    fun getMovie(title:String) : LiveData<Movies>
}