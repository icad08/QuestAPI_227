package com.example.myapi.repositori

interface ContainerApp{
    val repositoryDataSiswa : repositoryDataSiswa
}

class DefaultContainerApp : ContainerApp{
    private val beseurl = " "
    val logging HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    val klien = okHttpClient.Builder()
        .addInterceptor(logging)
        .build()

}