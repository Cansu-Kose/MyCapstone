package com.example.mycapstone.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mycapstone.domain.model.allcards.AllCardsModel
import com.example.mycapstone.domain.repository.AllCardsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AllCardsUseCase @Inject constructor(
    private val allCardsRepository: AllCardsRepository) {
    private var getCurrentAllCardsTemp=MutableLiveData<AllCardsModel>()

    val getCurrentAllCard:LiveData<AllCardsModel> = getCurrentAllCardsTemp

    fun getCards(productId:Int,quantity:Int){
        allCardsRepository.getProduct(productId, quantity).enqueue(object:Callback<AllCardsModel>{
            override fun onFailure(call: Call<AllCardsModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<AllCardsModel>, response: Response<AllCardsModel>) {
                getCurrentAllCardsTemp.value=response.body()
            }

        })
    }
}