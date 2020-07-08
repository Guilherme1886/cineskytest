package com.gui.antonio.cinesky.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.gui.antonio.cinesky.database.AppDatabase
import com.gui.antonio.cinesky.datasource.DataSource
import com.gui.antonio.cinesky.model.Model
import com.gui.antonio.cinesky.repository.Repository
import com.gui.antonio.cinesky.view.activity.MainActivity
import com.gui.antonio.cinesky.viewmodel.MainViewModel
import com.gui.antonio.cinesky.viewmodel.factory.MainViewModelFactory
import com.gui.antonio.cinesky.webservice.WebService
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideDependencies(context: Context, activity: MainActivity): MainViewModel {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "db_app").build()
        val webService = WebService()
        val model = Model(db.appDao())
        val dataSource = DataSource(model, webService)
        val repository = Repository(dataSource)
        return ViewModelProvider(activity, MainViewModelFactory(repository)).get(MainViewModel::class.java)
    }

}