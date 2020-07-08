package com.gui.antonio.cinesky.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gui.antonio.cinesky.data.Movies

@Dao
interface AppDao {

    @Query("SELECT * FROM movies")
    fun getMovies(): List<Movies>

    @Insert
    fun insertMovies(data: List<Movies>)

    @Query("DELETE FROM MOVIES")
    fun removeMovies()

    @Query("SELECT * FROM MOVIES where title = :title")
    fun getMovie(title: String): Movies

}