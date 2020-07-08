package com.gui.antonio.cinesky.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gui.antonio.cinesky.webservice.IWebService
import com.gui.antonio.cinesky.data.Movies
import com.gui.antonio.cinesky.model.IModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DataSource @Inject constructor(private val db: IModel, private val service: IWebService) : IDataSource {

    override val getMoviesError get() = service.getMoviesError

    override fun getMovies(): LiveData<List<Movies>> {
        val data = MutableLiveData<List<Movies>>()
        service.getMovies { movies ->
            CoroutineScope(Dispatchers.IO).launch {
                db.removeMovies()
                db.insertMovies(movies!!)
                data.postValue(db.getMovies())
            }
        }

        return data
    }

    override fun getMoviesOffline(): LiveData<List<Movies>> {
        val data = MutableLiveData<List<Movies>>()
        CoroutineScope(Dispatchers.IO).launch { data.postValue(db.getMovies()) }
        return data
    }

    override fun getMovie(title: String): LiveData<Movies> {
        val data = MutableLiveData<Movies>()
        CoroutineScope(Dispatchers.IO).launch { data.postValue(db.getMovie(title)) }
        return data
    }

}