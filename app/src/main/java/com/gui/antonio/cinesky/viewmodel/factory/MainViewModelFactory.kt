package com.gui.antonio.cinesky.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gui.antonio.cinesky.repository.IRepository
import com.gui.antonio.cinesky.viewmodel.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val repository: IRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(repository) as T
}