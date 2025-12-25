package com.example.myapi.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapi.modeldata.DataSiswa
import com.example.myapi.repositori.RepositoriDataSiswa
import com.example.myapi.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface DetailsUiState {
    data class Success(val detailSiswa: DataSiswa) : DetailsUiState
    object Error : DetailsUiState
    object Loading : DetailsUiState
}

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriDataSiswa: RepositoriDataSiswa
) : ViewModel(){

    private val siswaId: Int = checkNotNull(savedStateHandle[DestinasiDetail.idSiswa])
    var detailUiState: DetailsUiState by mutableStateOf(DetailsUiState.Loading)
        private set

    init {
        getSatuSiswa()
    }
    fun getSatuSiswa() {
        viewModelScope.launch {
            detailUiState = DetailsUiState.Loading
            detailUiState = try {
                DetailsUiState.Success(repositoriDataSiswa.getSatuSiswa(siswaId))
            } catch (e: IOException) {
                DetailsUiState.Error
            } catch (e: Exception) {
                DetailsUiState.Error
            }
        }
    }
)