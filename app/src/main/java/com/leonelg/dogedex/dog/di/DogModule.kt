package com.leonelg.dogedex.dog.di

import com.leonelg.dogedex.dog.data.DogRepository
import com.leonelg.dogedex.dog.data.IDogDataSource
import com.leonelg.dogedex.dog.framework.FakeDogDataSource
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

    @Provides
    fun provideIDogDataSource(): IDogDataSource =
        FakeDogDataSource()

    @Singleton
    @Provides
    fun provideIDogRepository(dogDataSource: IDogDataSource): IDogRepository =
        DogRepository(dogDataSource)

    @Provides
    fun provideGetDogsUseCase(dogRepository: IDogRepository) =
        GetDogsUseCase(dogRepository)
}