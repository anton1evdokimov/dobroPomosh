package com.dobro.dobro.data.api

import com.dobro.dobro.data.api.models.EventsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("Export?key=1HUttvae5iUuF3TVv02bKMwtKwTkDeu_V6TdnSuXT0fw&exportFormat=csv&gid=0")
    fun getEvents(): Call<ArrayList<EventsApiModel>>
}