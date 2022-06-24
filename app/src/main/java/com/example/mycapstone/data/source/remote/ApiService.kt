package com.example.mycapstone.data.source.remote


import com.example.mycapstone.domain.model.allcards.AllCardsModel
import com.example.mycapstone.domain.model.allproduct.AllProductsModel
import com.example.mycapstone.domain.model.allusers.AllUsersModel
import com.example.mycapstone.domain.model.allusers.Geolocation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current")
    fun getProduct(@Query("productId") productId:Int,@Query("quantity") quantity:Int):Call<AllCardsModel>

    @GET("current")
    fun getRating(@Query("count") count:Int,@Query("rate") rate:Double):Call<AllProductsModel>

    @GET("current")
    fun getAddress(@Query("city") city:String,@Query("geolocation") geolocation: Geolocation,@Query("number") number:Int,@Query("street") street:String,@Query("zipcode") zipcode:String):Call<AllUsersModel>

    @GET("current")
    fun getGeolocation(@Query("lat") lat:String,@Query("long") long:String):Call<AllUsersModel>

    @GET("current")
    fun getName(@Query("firstname") firstname:String,@Query("lastname") lastname:String):Call<AllUsersModel>
}