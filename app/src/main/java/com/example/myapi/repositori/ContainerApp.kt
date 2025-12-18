package com.example.myapi.repositori

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit

interface ContainerApp{
    val repositoryDataSiswa : repositoryDataSiswa
}

class DefaultContainerApp : ContainerApp{
    private val beseurl = " "
    val logging HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    val klien = okHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(beseurl)
        .addConverterFactory(
            Json{
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .client(klien)
        .build()")
        )

}