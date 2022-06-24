package com.example.mycapstone.domain.model.allusers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("geolocation")
    @Expose
    val geolocation: Geolocation,
    @SerializedName("number")
    @Expose
    val number: Int,
    @SerializedName("street")
    @Expose
    val street: String,
    @SerializedName("zipcode")
    @Expose
    val zipcode: String
)