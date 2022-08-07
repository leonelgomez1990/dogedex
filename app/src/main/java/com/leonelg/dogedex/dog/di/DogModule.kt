package com.leonelg.dogedex.dog.di

import com.leonelg.dogedex.dog.data.DogRepository
import com.leonelg.dogedex.dog.interfaces.IDogRepository
import com.leonelg.dogedex.dog.usecases.GetDogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DogModule {

    @Singleton
    @Provides
    fun provideIDogRepository(): IDogRepository =
        DogRepository()

    @Provides
    fun provideGetDogsUseCase(dogRepository: IDogRepository) =
        GetDogsUseCase(dogRepository)
}