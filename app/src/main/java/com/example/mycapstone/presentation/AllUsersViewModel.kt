package com.example.mycapstone.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycapstone.domain.model.allusers.AllUsersModel
import com.example.mycapstone.domain.model.allusers.Geolocation
import com.example.mycapstone.domain.usecase.AllUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllUsersViewModel @Inject constructor(private val useCase: AllUsersUseCase):ViewModel(){

    fun getAllUsers(firstname: String,lastname: String):LiveData<AllUsersModel>{
        useCase.getUsers(firstname, lastname)
        return useCase.getCurrentAllUsers
    }


}