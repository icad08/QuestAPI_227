package com.example.myapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapi.modeldata.DetailSiswa
import com.example.myapi.modeldata.UIStateSiswa
import com.example.myapi.modeldata.toDataSiswa
import com.example.myapi.modeldata.toUIStateSiswa
import com.example.myapi.repositori.RepositoriDataSiswa
import com.example.myapi.uicontroller.route.DestinasiEdit
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoriDataSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[DestinasiEdit.idSiswa])

    init {
        viewModelScope.launch {
            uiStateSiswa = repositoryDataSiswa.getSatuSiswa(itemId)
                .toUIStateSiswa(isEntryValid = true)
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = true)
    }

    suspend fun updateSiswa() {
        if (uiStateSiswa.isEntryValid) {
            repositoryDataSiswa.editSatuSiswa(itemId, uiStateSiswa.detailSiswa.toDataSiswa())
        }
    }
}