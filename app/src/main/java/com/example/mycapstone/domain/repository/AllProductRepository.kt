package com.example.mycapstone.domain.repository


import com.example.mycapstone.domain.model.allproduct.AllProductsModel
import retrofit2.Call

interface AllProductRepository {
    fun getRating(count: Int,rate: Double): Call<AllProductsModel>
}