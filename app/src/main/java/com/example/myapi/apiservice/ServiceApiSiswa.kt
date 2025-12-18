package com.example.myapi.apiservice

import retrofit2.http.POST

interface ServiceApiSiswa {
    @GET(bacateman.php)
    suspend fun getSiswa(): List<DataSiswa>

    @POST(insert.php)
    suspend fun postSiswa (@Body)
}