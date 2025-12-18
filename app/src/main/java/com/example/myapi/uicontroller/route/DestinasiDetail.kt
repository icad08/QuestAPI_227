package com.example.myapi.uicontroller.route

import com.example.myapi.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_siswa
    const val idSiswa = "idSiswa"
    val routeWithArgs = "$route/{$idSiswa}"
}