package com.example.mycapstone.domain.model.allcards

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("productId")
    @Expose
    val productId: Int,
    @SerializedName("quantity")
    @Expose
    val quantity: Int
)