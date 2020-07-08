package com.gui.antonio.cinesky.model

import com.gui.antonio.cinesky.data.Movies

interface IModel{
    fun getMovies() : List<Movies>
    fun getMovie(title:String) : Movies
    fun insertMovies(data: List<Movies>)
    fun removeMovies()
}