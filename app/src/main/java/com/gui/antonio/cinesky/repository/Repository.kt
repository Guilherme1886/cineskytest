package com.gui.antonio.cinesky.repository

import androidx.lifecycle.LiveData
import com.gui.antonio.cinesky.data.Movies
import com.gui.antonio.cinesky.datasource.IDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val dataSource: IDataSource) : IRepository {
    override fun getMovies() = dataSource.getMovies()
    override fun getMoviesOffline(): LiveData<List<Movies>> = dataSource.getMoviesOffline()
    override val getMoviesError: LiveData<Throwable> = dataSource.getMoviesError
    override fun getMovie(title: String): LiveData<Movies>  = dataSource.getMovie(title)
}