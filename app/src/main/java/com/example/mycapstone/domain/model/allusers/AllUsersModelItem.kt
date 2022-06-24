package com.example.mycapstone.domain.model.allusers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllUsersModelItem(
    @SerializedName("__v")
    @Expose
    val __v: Int,
    @SerializedName("address")
    @Expose
    val address: Address,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: Name,
    @SerializedName("password")
    @Expose
    val password: String,
    @SerializedName("phone")
    @Expose
    val phone: String,
    @SerializedName("username")
    @Expose
    val username: String
)