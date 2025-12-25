package com.example.myapi.apiservice

import com.example.myapi.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.*

interface ServiceApiSiswa {
    @GET("bacateman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insert.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    @GET("bacateman.php")
    suspend fun getSatuSiswa(@Query("id") id: Int): DataSiswa

    @PUT("editSiswa.php")
    suspend fun editSatuSiswa(@Query("id") id: Int, @Body dataSiswa: DataSiswa): Response<Void>

    // KOREKSI 4: Hapus '/{id}' dan pastikan nama file 'deleteSiswa.php'
    @DELETE("deleteSiswa.php")
    suspend fun hapusSatuSiswa(@Query("id") id: Int): Response<Void>
}