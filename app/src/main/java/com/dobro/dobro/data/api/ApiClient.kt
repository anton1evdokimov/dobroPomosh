package com.dobro.dobro.data.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient private constructor() {

    val api: ApiInterface
        get() = retrofit!!.create(
            ApiInterface::class.java
        )

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    companion object {

        private val BASE_URL = "https://docs.google.com/feeds/download/spreadsheets/"

        private var apiClient: ApiClient? = null
        private var retrofit: Retrofit? = null

        val instance: ApiClient?
            @Synchronized get() {

                if (apiClient == null) {

                    apiClient = ApiClient()
                }

                return apiClient
            }

    }
}
