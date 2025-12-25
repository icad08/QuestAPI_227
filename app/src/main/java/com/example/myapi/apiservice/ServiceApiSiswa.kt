package com.example.myapi.apiservice

import com.example.myapi.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.*

interface ServiceApiSiswa {
    @GET("bacasiswa.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertsiswa.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    // --- TAMBAHAN KODE DI BAWAH INI ---

    @GET("bacasiswa.php/{id}")
    suspend fun getSatuSiswa(@Query("id") id: Int): DataSiswa

    @PUT("editsiswa.php/{id}")
    suspend fun editSatuSiswa(@Query("id") id: Int, @Body dataSiswa: DataSiswa): Response<Void>

    @DELETE("deletesiswa.php/{id}")
    suspend fun hapusSatuSiswa(@Query("id") id: Int): Response<Void>
}