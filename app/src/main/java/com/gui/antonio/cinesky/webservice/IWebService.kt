package com.gui.antonio.cinesky.webservice

import androidx.lifecycle.LiveData
import com.gui.antonio.cinesky.data.Movies

interface IWebService {

    fun getMovies(onSuccess: (movies: List<Movies>?) -> Unit)
    val getMoviesError : LiveData<Throwable>

}