package com.gui.antonio.cinesky.model

import com.gui.antonio.cinesky.data.Movies
import com.gui.antonio.cinesky.database.AppDao
import javax.inject.Inject

class Model @Inject constructor(val dao : AppDao) : IModel {
    override fun getMovies(): List<Movies> = dao.getMovies()
    override fun getMovie(title: String): Movies = dao.getMovie(title)
    override fun insertMovies(data: List<Movies>) = dao.insertMovies(data)
    override fun removeMovies() = dao.removeMovies()
}