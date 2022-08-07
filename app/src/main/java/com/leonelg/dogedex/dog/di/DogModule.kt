package com.leonelg.dogedex.dog.di

import com.leonelg.dogedex.dog.data.DogRepository
import com.leonelg.dogedex.dog.data.IDogDataSource
import com.leonelg.dogedex.dog.framework.DogApiService
import com.leonelg.dogedex.dog.framework.DogDataSource
import com.leonelg.dogedex.dog.interfaces.IDogRepository
import com.leonelg.dogedex.dog.usecases.GetDogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DogModule {

    @Provides
    fun provideIDogDataSource(
        dogApiService: DogApiService
    ): IDogDataSource =
        DogDataSource(dogApiService, Dispatchers.IO)

    @Singleton
    @Provides
    fun provideIDogRepository(dogDataSource: IDogDataSource): IDogRepository =
        DogRepository(dogDataSource)

    @Provides
    fun provideGetDogsUseCase(dogRepository: IDogRepository) =
        GetDogsUseCase(dogRepository)
}