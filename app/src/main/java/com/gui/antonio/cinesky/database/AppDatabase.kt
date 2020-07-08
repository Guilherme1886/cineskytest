package com.gui.antonio.cinesky.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gui.antonio.cinesky.data.Movies

@Database(entities = [Movies::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao() : AppDao
}