package com.gui.antonio.cinesky.di

import android.content.Context
import com.gui.antonio.cinesky.view.activity.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, @BindsInstance activity: MainActivity): AppComponent
    }

    fun inject(activity: MainActivity)

}