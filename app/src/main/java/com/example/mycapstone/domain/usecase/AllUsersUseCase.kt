package com.example.mycapstone.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mycapstone.domain.model.allusers.AllUsersModel
import com.example.mycapstone.domain.repository.AllUsersRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AllUsersUseCase @Inject constructor(
    private val allUsersRepository: AllUsersRepository) {
    private var getCurrentAllUsersTemp=MutableLiveData<AllUsersModel>()

    val getCurrentAllUsers:LiveData<AllUsersModel> =getCurrentAllUsersTemp

    fun getUsers(firstname: String,lastname: String){
        allUsersRepository.getName(firstname,lastname).enqueue(object:Callback<AllUsersModel>{
            override fun onFailure(call: Call<AllUsersModel>, t: Throwable) {
            }
            override fun onResponse(call: Call<AllUsersModel>, response: Response<AllUsersModel>) {
                getCurrentAllUsersTemp.value=response.body()
            }

        })

    }


}