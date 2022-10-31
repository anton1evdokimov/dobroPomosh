package com.dobro.dobro.data.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EventsApiModel {
    @SerializedName("id") @Expose
    var id: Int? = null
    @SerializedName("image") @Expose
    var image: String? = null
    @SerializedName("name") @Expose
    var name: String? = null
    @SerializedName("description") @Expose
    var description: String? = null
    @SerializedName("price") @Expose
    var price: String? = null
}