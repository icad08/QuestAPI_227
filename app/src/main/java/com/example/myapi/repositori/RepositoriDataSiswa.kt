package com.example.myapi.repositori

import com.example.myapi.apiservice.ServiceApiSiswa
import com.example.myapi.modeldata.DataSiswa
import retrofit2.Response

interface RepositoriDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDatasiswa(dataSiswa: DataSiswa): Response<Void>

    // Tambahan Interface
    suspend fun getSatuSiswa(id: Int): DataSiswa
    suspend fun editSatuSiswa(id: Int, dataSiswa: DataSiswa): Response<Void>
    suspend fun hapusSatuSiswa(id: Int): Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val siswaApi: ServiceApiSiswa
) : RepositoriDataSiswa {
    override suspend fun getDataSiswa() = siswaApi.getSiswa()
    override suspend fun postDatasiswa(dataSiswa: DataSiswa) = siswaApi.postSiswa(dataSiswa)

    // Tambahan Implementasi
    override suspend fun getSatuSiswa(id: Int) = siswaApi.getSatuSiswa(id)
    override suspend fun editSatuSiswa(id: Int, dataSiswa: DataSiswa) = siswaApi.editSatuSiswa(id, dataSiswa)
    override suspend fun hapusSatuSiswa(id: Int) = siswaApi.hapusSatuSiswa(id)
}