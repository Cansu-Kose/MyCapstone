package com.example.mycapstone.domain.model.allproduct

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllProductsModelItem(
    @SerializedName("category")
    @Expose
    val category: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("image")
    @Expose
    val image: String,
    @SerializedName("price")
    @Expose
    val price: Double,
    @SerializedName("rating")
    @Expose
    val rating: Rating,
    @SerializedName("title")
    @Expose
    val title: String
)