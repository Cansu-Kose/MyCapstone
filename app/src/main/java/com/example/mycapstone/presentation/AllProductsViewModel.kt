package com.example.mycapstone.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycapstone.domain.model.allproduct.AllProductsModel
import com.example.mycapstone.domain.usecase.AllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllProductsViewModel @Inject constructor(private val useCase: AllProductsUseCase):ViewModel(){

    fun getAllProducts(count: Int,rate: Double):LiveData<AllProductsModel>{
        useCase.getRatings(count, rate)
        return useCase.getCurrentAllProducts
    }

}