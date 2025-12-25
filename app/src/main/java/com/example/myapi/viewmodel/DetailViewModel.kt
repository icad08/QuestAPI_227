package com.example.myapi.viewmodel

import com.example.myapi.modeldata.DataSiswa

sealed interface DetailsUiState {
    data class Success(val detailSiswa: DataSiswa) : DetailsUiState
    object Error : DetailsUiState
    object Loading : DetailsUiState

class DetailViewModel {
}