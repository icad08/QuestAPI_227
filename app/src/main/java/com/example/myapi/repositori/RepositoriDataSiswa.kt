package com.example.myapi.repositori


import com.example.myapi.apiservice.serviceApiSiswa
import com.example.myapi.modeldata.DataSiswa
import retrofit2.Response

interface RepositoriDataSiswa{
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDatasiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
}

class JaringanRepositoryDataSiswa(
    private val siswaApi: ServiceApiSiswa
) : RepositoriDataSiswa{
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDatasiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
    }