package com.example.mycapstone.di

import com.example.mycapstone.data.repository.AllCardsRepositoryImp
import com.example.mycapstone.data.repository.AllProductsRepositoryImp
import com.example.mycapstone.data.repository.AllUsersRepositoryImp
import com.example.mycapstone.data.source.remote.ApiService
import com.example.mycapstone.domain.repository.AllCardsRepository
import com.example.mycapstone.domain.repository.AllProductRepository
import com.example.mycapstone.domain.repository.AllUsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder().baseUrl("https://fakestoreapi.com/users/")
            .addConverterFactory(gsonConverterFactory)
            .build();
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAllProductsRepository(apiService: ApiService):AllProductRepository{
        return AllProductsRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideAllUsersRepository(apiService: ApiService):AllUsersRepository{
        return AllUsersRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideAllCardsRepository(apiService: ApiService):AllCardsRepository{
        return AllCardsRepositoryImp(apiService)
    }

}