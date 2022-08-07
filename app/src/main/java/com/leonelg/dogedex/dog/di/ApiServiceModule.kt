package com.leonelg.dogedex.dog.di

import com.leonelg.dogedex.dog.framework.DogApiService
import com.leonelg.dogedex.dog.framework.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): DogApiService =
        retrofit.create(DogApiService::class.java)
}