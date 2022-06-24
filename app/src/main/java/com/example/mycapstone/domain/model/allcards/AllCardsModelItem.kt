package com.example.mycapstone.domain.model.allcards

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllCardsModelItem(
    @SerializedName("__v")
    @Expose
    val __v: Int,
    @SerializedName("date")
    @Expose
    val date: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("products")
    @Expose
    val products: List<Product>,
    @SerializedName("userId")
    @Expose
    val userId: Int
)