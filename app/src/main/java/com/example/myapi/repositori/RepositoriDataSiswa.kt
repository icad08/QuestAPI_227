package com.example.myapi.repositori

import com.example.myapi.apiservice.ServiceApiSiswa
import com.example.myapi.modeldata.DataSiswa
import retrofit2.Response

interface RepositoriDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDatasiswa(dataSiswa: DataSiswa): Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val siswaApi: ServiceApiSiswa
) : RepositoriDataSiswa {

    override suspend fun getDataSiswa(): List<DataSiswa> = siswaApi.getSiswa()
    override suspend fun postDatasiswa(dataSiswa: DataSiswa) = siswaApi.postSiswa(dataSiswa)
}