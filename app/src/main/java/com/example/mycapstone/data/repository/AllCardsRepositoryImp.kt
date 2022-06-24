package com.example.mycapstone.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.mycapstone.data.source.remote.ApiService
import com.example.mycapstone.domain.model.allcards.AllCardsModel
import com.example.mycapstone.domain.repository.AllCardsRepository
import retrofit2.Call

class AllCardsRepositoryImp(private val apiService: ApiService):AllCardsRepository {
    override fun getProduct(productId: Int, quantity: Int): Call<AllCardsModel> {
        return apiService.getProduct(productId, quantity)
    }
}