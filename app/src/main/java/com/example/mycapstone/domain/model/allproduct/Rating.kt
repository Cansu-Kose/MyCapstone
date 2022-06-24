package com.example.mycapstone.domain.model.allproduct

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("rate")
    @Expose
    val rate: Double
)