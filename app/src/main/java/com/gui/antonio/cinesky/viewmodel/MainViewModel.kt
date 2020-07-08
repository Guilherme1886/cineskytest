package com.gui.antonio.cinesky.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gui.antonio.cinesky.data.Movies
import com.gui.antonio.cinesky.repository.IRepository

class MainViewModel(private val repository: IRepository) : ViewModel(), IMainViewModel {
    override fun getMovies(): LiveData<List<Movies>> = repository.getMovies()
    override fun getMoviesOffline(): LiveData<List<Movies>> = repository.getMoviesOffline()
    override val getMoviesError: LiveData<Throwable> get() = repository.getMoviesError
    override fun getMovie(title: String): LiveData<Movies> = repository.getMovie(title)
}