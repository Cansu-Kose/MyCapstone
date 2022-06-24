package com.example.mycapstone.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mycapstone.domain.model.allproduct.AllProductsModel
import com.example.mycapstone.domain.repository.AllProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AllProductsUseCase @Inject constructor(
    private val allProductRepository: AllProductRepository) {
    private var getCurrentAllProductsTemp=MutableLiveData<AllProductsModel>()

    val getCurrentAllProducts: LiveData<AllProductsModel> =getCurrentAllProductsTemp

    fun getRatings(count: Int,rate: Double){
        allProductRepository.getRating(count, rate).enqueue(object :Callback<AllProductsModel>{
            override fun onFailure(call: Call<AllProductsModel>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<AllProductsModel>,
                response: Response<AllProductsModel>
            ) {
                getCurrentAllProductsTemp.value=response.body()
            }

        })
    }
}