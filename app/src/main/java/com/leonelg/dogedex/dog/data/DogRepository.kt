package com.leonelg.dogedex.dog.data

import com.leonelg.dogedex.dog.domain.Dog
import com.leonelg.dogedex.dog.interfaces.IDogRepository
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogDataSource: IDogDataSource
) : IDogRepository {

    override suspend fun getDogCollection(): List<Dog> =
        dogDataSource.getAllDogs()

}