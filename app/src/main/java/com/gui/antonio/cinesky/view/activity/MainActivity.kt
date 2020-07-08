package com.gui.antonio.cinesky.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.gui.antonio.cinesky.R
import com.gui.antonio.cinesky.di.DaggerAppComponent
import com.gui.antonio.cinesky.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.factory().create(this, this).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}