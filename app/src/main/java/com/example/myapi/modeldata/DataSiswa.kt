package com.example.myapi.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class DataSiswa(
    val id: Int,
    val nama: String,
    val alamat: String,
    val telepon: String
)

data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telepon: String = "",
)

fun DetailSiswa.toDataSiswa(): DataSiswa = DataSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid()
)

