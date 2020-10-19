package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repositories.FactoryRandomApiRepository

/**
 * Factory for ViewModels
 */
class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        when {
            modelClass.isAssignableFrom(RandomApiViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                return RandomApiViewModel(
                    FactoryRandomApiRepository.getRandomRepo()
                ) as T
            }

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}