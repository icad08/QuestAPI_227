package com.example.myapi.apiservice

import com.example.myapi.modeldata.DataSiswa
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface serviceApiSiswa {
    @GET("bacasiswa.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertsiswa.php")
    @Headers("Content-Type: application/json")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): Response<Void>
}