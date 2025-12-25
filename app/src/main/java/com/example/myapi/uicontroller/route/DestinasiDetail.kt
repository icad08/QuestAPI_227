package com.example.myapi.uicontroller.route

import com.example.myapi.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val idSiswa = "itemId"
    val routeWithArgs = "$route/{$idSiswa}"
}