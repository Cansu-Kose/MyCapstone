package com.example.mycapstone.domain.repository

import com.example.mycapstone.domain.model.allusers.AllUsersModel
import com.example.mycapstone.domain.model.allusers.Geolocation
import retrofit2.Call


interface AllUsersRepository {
    fun getAdress(city:String,geolocation: Geolocation,number: Int,street: String,zipcode: String): Call<AllUsersModel>
    fun getName(firstname: String,lastname: String):Call<AllUsersModel>
    fun getGeolocation(lat: String,long: String):Call<AllUsersModel>
}