package com.example.mycapstone.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycapstone.domain.model.allcards.AllCardsModel
import com.example.mycapstone.domain.usecase.AllCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllCardsViewModel @Inject constructor(private val useCase: AllCardsUseCase):ViewModel(){

    fun getAllCards(productId: Int,quantity: Int):LiveData<AllCardsModel>{
        useCase.getCards(productId, quantity)
        return useCase.getCurrentAllCard
    }

}