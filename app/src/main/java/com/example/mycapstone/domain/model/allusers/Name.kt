package com.example.mycapstone.domain.model.allusers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("firstname")
    @Expose
    val firstname: String,
    @SerializedName("lastname")
    @Expose
    val lastname: String
)