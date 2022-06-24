package com.example.mycapstone.data.repository


import com.example.mycapstone.data.source.remote.ApiService
import com.example.mycapstone.domain.model.allproduct.AllProductsModel
import com.example.mycapstone.domain.repository.AllProductRepository
import retrofit2.Call

class AllProductsRepositoryImp(private val apiService: ApiService):AllProductRepository {
    override fun getRating(count: Int, rate: Double): Call<AllProductsModel> {
        return apiService.getRating(count, rate)
    }
}