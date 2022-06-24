package com.example.mycapstone.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.mycapstone.data.source.remote.ApiService
import com.example.mycapstone.domain.model.allusers.AllUsersModel
import com.example.mycapstone.domain.model.allusers.Geolocation
import com.example.mycapstone.domain.repository.AllUsersRepository
import retrofit2.Call

class AllUsersRepositoryImp(private val apiService: ApiService):AllUsersRepository {
    override fun getAdress(
        city: String,
        geolocation: Geolocation,
        number: Int,
        street: String,
        zipcode: String
    ): Call<AllUsersModel> {
        return apiService.getAddress(city, geolocation, number, street, zipcode)
    }

    override fun getName(firstname: String, lastname: String): Call<AllUsersModel> {
        return apiService.getName(firstname, lastname)
    }

    override fun getGeolocation(lat: String, long: String): Call<AllUsersModel> {
        return apiService.getGeolocation(lat, long)
    }
}