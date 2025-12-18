package com.example.myapi.repositori

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface ContainerApp {
    val repositoryDataSiswa : RepositoriDataSiswa
}

class DefaultContainerApp : ContainerApp {
    private val baseurl = "http://10.0.2.2/umyTI/"

    private val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory(json.asConverterFactory("application/json".toMediaType())))
        .baseUrl(baseurl)
        .build()

    private val serviceApiSiswa: serviceApiSiswa by lazy {
        retrofit.create(serviceApiSiswa::class.java)
    }

    override val repositoryDataSiswa: RepositoriDataSiswa by lazy {
        JaringanRepositoryDataSiswa(serviceApiSiswa)
    }
}