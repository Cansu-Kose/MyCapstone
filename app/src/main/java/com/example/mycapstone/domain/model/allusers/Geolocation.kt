package com.example.mycapstone.domain.model.allusers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Geolocation(
    @SerializedName("lat")
    @Expose
    val lat: String,
    @SerializedName("long")
    @Expose
    val long: String
)