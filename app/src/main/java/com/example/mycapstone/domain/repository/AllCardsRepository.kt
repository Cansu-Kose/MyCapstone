package com.example.mycapstone.domain.repository

import com.example.mycapstone.domain.model.allcards.AllCardsModel
import retrofit2.Call


interface AllCardsRepository {
    fun getProduct(productId:Int,quantity:Int):Call<AllCardsModel>
}