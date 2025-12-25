package com.example.myapi.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapi.modeldata.DataSiswa
import com.example.myapi.repositori.RepositoriDataSiswa

sealed interface DetailsUiState {
    data class Success(val detailSiswa: DataSiswa) : DetailsUiState
    object Error : DetailsUiState
    object Loading : DetailsUiState
}

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriDataSiswa: RepositoriDataSiswa
) : ViewModel()
)